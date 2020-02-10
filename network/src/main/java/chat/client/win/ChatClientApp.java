package chat.client.win;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatClientApp {
	private static final int SERVER_PORT = 3;

	public static void main(String[] args) {
		String name = null;
		String nickName = null;
		Scanner scanner = new Scanner(System.in);
		PrintWriter pw = null;
		Socket socket = new Socket();
		
		while( true ) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			
			System.out.print("닉네임>>");
			nickName = scanner.nextLine();
			
			try {
				socket.connect(new InetSocketAddress("0.0.0.0", SERVER_PORT));
				log("connected");
				pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
				
				new ChatWindow(name, socket, nickName).show();
				
				String request = "join:" + nickName + "\r\n";
				pw.println(request);
				pw.flush();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if (name.isEmpty() == false ) {
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		
		scanner.close();
		
		///////////////////////////////////
		
		
		//////////////////////////////////
		
		
		// new ChatWindow(name).show();
	}

	public static void log(String log) {
		System.out.println("[client]" + log);
	}
}
