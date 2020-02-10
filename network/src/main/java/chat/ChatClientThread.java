package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatClientThread extends Thread {
	private Socket socket = null;
	private String nickname = null;
	BufferedReader br = null;
	
	public ChatClientThread(Socket socket, String nickname) {
		this.socket = socket;
		this.nickname = nickname;
	}

	@Override
	public void run() {
		// reader를 통해 읽은 데이터 콘솔에 출력하기 (message 처리)
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			while(true) {
				String message = br.readLine();   // blocking
				System.out.println(">>" + message);
			}
		} catch (IOException e) {
			System.out.println("정상 종료되었습니다.");
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
}