package chat.client.win;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ChatClientApp {
	private static final String SERVER_IP="127.0.0.1";
	private static final int SERVER_PORT=5005;
	static List<String> clientList = new ArrayList<>();
	
	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket=null;
		
		
		
		try {
			// 1. socket 
			socket= new Socket();
			// 2. connect to server 
			socket.connect(new InetSocketAddress(SERVER_IP,SERVER_PORT));
			// 3. ioStream 생성 
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"utf-8"); // byte -> char 
			BufferedReader br = new BufferedReader(isr); // char- > 체인 보조 스트림으로 만들어 성능을 향상시킨다.
			
			PrintWriter	pw = new PrintWriter(
					new OutputStreamWriter(
							socket.getOutputStream(), StandardCharsets.UTF_8), true);
//			boolean sw;
//			
//			String num=br.readLine();
//			int size=Integer.parseInt(num);
//			for(int i=0;i<size;i++) {
//				clientList.add(br.readLine());
//			}
//			
//			
//	
//			System.out.println("--------------------");
//			// 대화명 입력 
//			while( true ) {
//				sw=true;
//				name=null;
//				System.out.println("대화명을 입력하세요.");
//				System.out.print(">>> ");
//				name = scanner.nextLine().trim();	
//				
//				if (!name.isEmpty()) {
//					for(String s : clientList) {
//						System.out.print("참여자:"+s+" ");
//						if(name.equals(s)) {
//							sw=false;
//						}
//					}
//					
//					if(sw)break;
//				}
//			
//					
//				System.out.println("대화명이 중복 혹은 공백입니다.\n");
//			}
			
			while(true ) {
				System.out.println("대화명을 입력하세요: ");
				name = scanner.nextLine().trim();
				
				if(!name.isEmpty()) {
					break;
				}
			
			}
			pw.println(name);
			String ck=br.readLine();
			while(!"ok".equals(ck)) {
				System.out.println("중복입니다 다시 입력해주세요 : ");
				name=scanner.nextLine().trim();
				if(name.isEmpty()) {
					continue;
				}
				pw.println(name);
				ck=br.readLine();
			}
			
			scanner.close();
		
		
		
		// 4. join 프로토콜 요청 및 처리 
		pw.println("join:"+name);
		// 5. join이 성공 응답을 받으면 실행 
		String joinCheck = br.readLine();
		System.out.println("연결중....");
		if("join:ok".equals(joinCheck))
			new ChatWindow(name,socket).show();
			
		
		
		}catch(Exception e){
			e.printStackTrace();

	      }
		
			
	}

}
