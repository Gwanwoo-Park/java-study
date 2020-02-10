package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private static final int SERVER_PORT = 3;
	
	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		String nickname;
		
		try {
			//1. Scanner 생성(표준입력, 키보드 연결)
			scanner = new Scanner(System.in);
			
			//2. Socket 생성
			socket = new Socket();
			
			//3. 서버 연결
			socket.connect(new InetSocketAddress("0.0.0.0", SERVER_PORT));
			log("connected");
			
			//4. IOStream 생성(받아오기)
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			System.out.print("닉네임>>");
			nickname = scanner.nextLine();
			pw.println("join:" + nickname);
			pw.flush();
			
			new ChatClientThread(socket, nickname).start();
			
			while(true) {
				//5. 키보드 입력 받기
				String line = scanner.nextLine();
				
				if("quit".equals(line)) {
					pw.println("quit:message:" + nickname);
					break;
				} else {
					//6. 데이터 쓰기
					pw.println("message:" + nickname + ":" + line);
				}
				//7. 데이터 읽기
//				String data = br.readLine();  //blocking
//				if(data == null) {
//					log("closed by server");
//					break;
//				}
				
				//System.out.println(data);
				
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(scanner != null) {
					scanner.close();
				}
				
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void log(String log) {
		System.out.println("[client]" + log);
	}
}
