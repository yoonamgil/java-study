package http;

import java.io.IOException;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHttpServer {
	private static final int PORT = 8088;

	public static void main(String[] args) {

		ServerSocket serverSocket = null;

		try {
			// 1. Create Server Socket
			serverSocket = new ServerSocket();
			   
			// 2. Bind
			//String localhost = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind( new InetSocketAddress( "127.0.0.1", PORT ) );
			consoleLog("httpd starts at" + PORT);

			while (true) {
				// 3. Wait for connecting ( accept )
				Socket socket = serverSocket.accept();

				// 4. Delegate Processing Request 쓰레드 한테 위임하는것 
				new RequestHandler(socket).start();
			}

		} catch (IOException ex) {
			consoleLog("error:" + ex);
		} finally {
			// 5. 자원정리
			try {
				if (serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException ex) {
				consoleLog("error:" + ex);
			}
		}
	}

	public static void consoleLog(String message) {
		System.out.println("[HttpServer#" + Thread.currentThread().getId()  + "] " + message);
	}
}
