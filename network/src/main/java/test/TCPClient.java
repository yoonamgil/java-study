package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;


public class TCPClient {
	
	private static final String SERVER_IP="127.0.0.1";
	private static final int SERVER_PORT=5001;
	public static void main(String[] args) {
		// 1.소켓생성
		
		Socket socket=null;
		
		//2. 서버연결
		
		try {
			
			socket = new Socket();
			
			
			// 1-1 소켓 버퍼 사이즈 확인  
			int receiveBufferSize = socket.getReceiveBufferSize();
			int sendBuffersize= socket.getSendBufferSize();
			
			System.out.println(receiveBufferSize + ":"+ sendBuffersize);
			
			//1-2 소켓 버퍼 사이즈 변경 
			socket.setReceiveBufferSize(1024*10);
			socket.setSendBufferSize(1024*10);
			
			//1-3 SO_NODELAY(Nagle Algorithm off)
			socket.setTcpNoDelay(true);
			
			//1-4 SO_TimeOut
			socket.setSoTimeout(1000);
			
			
			receiveBufferSize = socket.getReceiveBufferSize();
			sendBuffersize= socket.getSendBufferSize();
			socket.connect(new InetSocketAddress(SERVER_IP,SERVER_PORT));
			System.out.println(receiveBufferSize + ":"+ sendBuffersize);
			
			System.out.println("[client] con"
					+ "nected");
			
			//3. IOstream 
			
			InputStream is = socket.getInputStream();
			OutputStream os= socket.getOutputStream();
			
			//4. 쓰기 
			
			String data = "Hello world";
			os.write(data.getBytes("UTF-8"));
			
			//5.읽기 
			  byte[] buffer= new byte[256];
			  
			  
			  int readByteCount = is.read(buffer); // blocking 
			  if (readByteCount == -1) {
				  //Client 에서 정상종료 close를 호출하였다. 
				  
				  System.out.print("Close by Server");
				  return; // 한번쓰고 한번읽고 빠지는것 
			  }
			  
			  String data1= new String(buffer,0,readByteCount,"UTF-8");
			   System.out.println("[client] received"+data1);
			
		} catch (SocketTimeoutException e) {
			System.out.println("[client] time out ");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
			if(socket != null && (socket.isClosed() == false))
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

}
