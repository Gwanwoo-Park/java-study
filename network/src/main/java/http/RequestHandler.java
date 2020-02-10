package http;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	private static final String DOCUMENT_ROOT = "./webapp";
	private Socket socket;

	public RequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			consoleLog("connected from " + inetSocketAddress.getAddress().getHostAddress() + ":"
					+ inetSocketAddress.getPort());
			// 4. receive IOStream
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			// get IOStream
			OutputStream outputStream = socket.getOutputStream();
			String request = null;
			
			while(true) {
				String line = br.readLine(); // blocking
				
				// 브라우저가 연결을 끊은 경우
				if (line == null) {
					break;
				}
				//요청이 헤더만 읽은 경우
				if(line.equals("")) {
					break;
				}
				// header의 첫번째 line만 읽은 경우
				if(request == null) {
					request = line;
					break;
				}
			}
			
			consoleLog(request);
			
			String[] tokens = request.split(" ");
			if("GET".equals(tokens[0])) {
				responseStaticResource(outputStream, tokens[1], tokens[2]);
			} else { // [POST, DELETE, PUT], HEAD, CONNECT
				//응답 예시
				// HTTP/1.1 400 Bad Request\r\n
				// Content-Type:text/html; charset=utf-8\r\n
				// \r\n
				// HTML 에러 문서(./webapp/error/400.html)
				
				response400Error(outputStream, tokens[2]);
			}
		} catch (Exception ex) {
			consoleLog("error:" + ex);
		} finally {
			// clean-up
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}

			} catch (IOException ex) {
				consoleLog("error:" + ex);
			}
		}
	}
	
	private void responseStaticResource(
		OutputStream outputStream, 
		String uri, 
		String protocol) throws IOException {
		if("/".equals(uri)) {
			uri = "/index.html";
		}
		
		File file = new File(DOCUMENT_ROOT + uri);
		if(!file.exists()) {
			//응답 예시
			// HTTP/1.1 404 Not Found\r\n
			// Content-Type:text/html; charset=utf-8\r\n
			// \r\n
			// HTML 에러 문서(./webapp/error/404.html)
			
			response404Error(outputStream, protocol);
			return;
		}
		
		// nio
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());
		
		// 응답
		outputStream.write((protocol + " 200 OK\r\n").getBytes("UTF-8"));
		outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
		outputStream.write("\r\n".getBytes());
		outputStream.write(body);
	}
	
	private void response404Error(OutputStream outputStream, String protocol) throws IOException {
		File file = new File(DOCUMENT_ROOT + "/error/404.html");
		String contentType = Files.probeContentType(file.toPath());
		byte[] body = Files.readAllBytes(file.toPath());
		
		// 응답
		outputStream.write((protocol + " 404 Not Found\r\n").getBytes("UTF-8"));
		outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
		outputStream.write("\r\n".getBytes());
		outputStream.write(body);
	}
	
	private void response400Error(OutputStream outputStream, String protocol) throws IOException {
		File file = new File(DOCUMENT_ROOT + "/error/400.html");
		String contentType = Files.probeContentType(file.toPath());
		byte[] body = Files.readAllBytes(file.toPath());
		
		// 응답
		outputStream.write((protocol + " 400 Bad Request\r\n").getBytes("UTF-8"));
		outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
		outputStream.write("\r\n".getBytes());
		outputStream.write(body);
	}

	public void consoleLog(String message) {
		System.out.println("[RequestHandler#" + getId() + "] " + message);
	}
}