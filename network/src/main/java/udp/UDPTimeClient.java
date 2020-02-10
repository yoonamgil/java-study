package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class UDPTimeClient {
	private static final String  SERVER_IP="127.0.0.1";
	private static final int SERVER_PORT= 7000;
	private static final int BUFFER_SIZE= 1024;
	public static void main(String[] args) throws IOException {
		Scanner scanner= null;
		DatagramSocket socket= null;
			try {
			//1.Scanner todtjd 
				scanner= new Scanner(System.in);
				
			//2. Scoket 생성
			socket = new DatagramSocket();
			
			while(true) {
				System.out.println(">>");
				String line = scanner.nextLine();
				if("quit".equals(line)) {
					break; 
				}
				//4. 데이터 쓰기
				byte[] sendData =  line.getBytes("UTF-8");
				DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,new InetSocketAddress(SERVER_IP,SERVER_PORT));
				socket.send(sendPacket);
				
				
				//5. 데이터 읽기
				DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE],BUFFER_SIZE);
				socket.receive(receivePacket); //blocking
				
				byte[] data= receivePacket.getData();
				int length= receivePacket.getLength();
				String message = new String(data,0,length,"UTF-8");
				
				System.out.println("<<: "+message);
				
			}
			
			
			
			//4. 데이터 쓰기 
			
			
			
		} catch (SocketTimeoutException e) {
			System.out.println("[client] time out ");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		finally {
			if(socket != null && (socket.isClosed() == false))
			socket.close();
	}
	}

}
