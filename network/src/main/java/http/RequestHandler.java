package http;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	private Socket socket;
	private static final String DOCUMENT_ROOT ="./webapp";
	
	public RequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// get IOStream

			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			consoleLog("connected from " + inetSocketAddress.getAddress().getHostAddress() + ":"
					+ inetSocketAddress.getPort());

			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			OutputStream outputStream = socket.getOutputStream();

			String request = null;
			while (true) {
				String line = br.readLine();

				// 브라우저가 연결을 끊음
				if (line == null) {
					break;
				}
				// Request의 헤더만 읽음
				if ("".equals(line)) {
					break;
				}

				// Header의 첫번째 라인만 읽음
				if (request == null) {
					request = line;
					break;
				}
				// consoleLog(line);
			}
			consoleLog(request);
			String[] tokens=request.split(" ");
			if("GET".equals(tokens[0])) {
				
				responseStaticResource(outputStream,tokens[1],tokens[2]);
			}else if("POST".equals(tokens[0])||"DELETE".equals(tokens[0])||"PUT".equals(tokens[0])) {
				// 응답 예시 
//				outputStream.write("HTTP/1.1 400 Bad Request\r\n".getBytes("UTF-8"));
//				outputStream.write("Content-Type:text/html; charset=utf-8\r\n".getBytes("UTF-8"));
//				outputStream.write("\r\n".getBytes());
//				outputStream.write("<h1>HTML 에러 문서(./webapp/Error/400.html)</h1>".getBytes("UTF-8"));
				
				response400Error(outputStream,tokens[2]);
				
				
			} //[post,delete,put],headconnect
				
				
				
				
				
				
			
			// 예제 응답입니다.
			// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.
//			outputStream.write("HTTP/1.1 200 OK\r\n".getBytes("UTF-8"));
//			outputStream.write("Content-Type:text/html; charset=utf-8\r\n".getBytes("UTF-8"));
//			outputStream.write("\r\n".getBytes());
//			outputStream.write("<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된 것입니다.</h1>".getBytes("UTF-8"));

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

	private void responseStaticResource(OutputStream outputStream, String uri, String protocol) throws IOException {
		if("/".equals(uri)) {
			uri="/index.html";
			
		}
		File file = new File(DOCUMENT_ROOT+uri);
		if(!file.exists()) {
			// 응답 예시 
//			outputStream.write("HTTP/1.1 404 Not Found\r\n".getBytes("UTF-8"));
//			outputStream.write("Content-Type:text/html; charset=utf-8\r\n".getBytes("UTF-8"));
//			outputStream.write("\r\n".getBytes());
//			outputStream.write("<h1>HTML 에러 문서(./webapp/Error/400.html)</h1>".getBytes("UTF-8"));
			
			response404Error(outputStream,protocol);
			
			return; 
		}
		
		// nio
		byte[] body =Files.readAllBytes(file.toPath());
		String contentType= Files.probeContentType(file.toPath());
		
		
		// 응답 
		outputStream.write((protocol+" 200 OK\r\n").getBytes("UTF-8"));
		outputStream.write(("Content-Type:"+contentType+"; charset=utf-8\r\n").getBytes("UTF-8"));
		outputStream.write("\r\n".getBytes());
		outputStream.write(body);
		
		
	}

	public void consoleLog(String message) {
		System.out.println("[RequestHandler#" + getId() + "] " + message);
	}
	
	public void response404Error(OutputStream os, String protocol) throws UnsupportedEncodingException, IOException {
		File file = new File(DOCUMENT_ROOT+"/error/404.html");
		byte[] body =Files.readAllBytes(file.toPath());
		String contentType= Files.probeContentType(file.toPath());
		
		os.write((protocol+"404 Not Found\r\n").getBytes("UTF-8"));
		
		os.write(("Content-Type:"+contentType+"; charset=utf-8\r\n").getBytes("UTF-8"));
		os.write("\r\n".getBytes());
		os.write(body);
		
		
	}
	public void response400Error(OutputStream os, String protocol) throws UnsupportedEncodingException, IOException {
		
		File file = new File(DOCUMENT_ROOT+"/error/400.html");
		
		
		byte[] body =Files.readAllBytes(file.toPath());
		String contentType= Files.probeContentType(file.toPath());
		
		os.write((protocol+"400 Not Found\r\n").getBytes("UTF-8"));
		
		os.write(("Content-Type:"+contentType+"; charset=utf-8\r\n").getBytes("UTF-8"));
		os.write("\r\n".getBytes());
		os.write(body);
		
	}
}
