package test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Localhost {
	private static final String SERVER_IP="127.0.0.1";
	private static final int SERVER_PORT=5001;
	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			byte[] addresses=inetAddress.getAddress();
			
			for(byte address : addresses) {
				
				System.out.println(address & 0x000000ff);// 이해하고 넘어가기 
			}
			System.out.println(Arrays.toString(addresses));
			
			String hostName = inetAddress.getHostName();
			String hostAddress = inetAddress.getHostAddress();
			
			System.out.println(hostName);
			System.out.println(hostAddress);
			
			
	} catch (UnknownHostException e) {
		
			e.printStackTrace();
		}

	}

}
