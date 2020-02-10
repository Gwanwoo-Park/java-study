package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickName;
	private Socket socket;
	PrintWriter pw = null;
	List<Writer> listWriters;
	
	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}
	
	@Override
	public void run() {
		InetSocketAddress remoteInetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
		int remotePort = remoteInetSocketAddress.getPort();
		String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
		ChatServer.log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");
		
		try {
			//2. 스트림 얻기
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			while(true) {
				//3. 요청 처리
				String data = br.readLine(); //blocking
				if(data == null) {
					ChatServer.log("클라이언트로 부터 연결 끊김");
					doQuit(pw);
					break;
				}
				ChatServer.log(data);
				
				// 4. 프로토콜 분석
				String[] tokens = data.split(":");
				
				if("join".equals(tokens[0])) {
					doJoin(tokens[1], pw);
				} else if("message".equals(tokens[0])) {
					doMessage(tokens[1] + ":" + tokens[2]);
				} 
//				else if("quit".equals(tokens[0])) {
//					doQuit(pw);
//				}
				else {
					ChatServer.log("에러:알 수 없는 요청(" + tokens[0] + ")");
				}
				
				//6. 데이터 쓰기
				// pw.println(data);
			}
		} catch(SocketException e) {
			ChatServer.log("suddenly closed by client");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket != null && socket.isClosed()) {
					socket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void doJoin(String nickName, Writer pw) {
		this.nickName = nickName;
		//writer pool에 저장
		broadcast(nickName + " 님이 접속했습니다.");
		
		listWriters.add(pw);
	}
	
	private void broadcast(String message) {
		synchronized(listWriters) {
			for(Writer writer : listWriters) {
				PrintWriter printwriter = (PrintWriter) writer;
				printwriter.println(message);
				printwriter.flush();
			}
		}
	}

	private void doMessage(String message) {
		broadcast(message);
	}
	
	private void doQuit(Writer pw) {
		listWriters.remove(pw);
		
		broadcast(nickName + " 님이 퇴장하셨습니다.");
	}
}
