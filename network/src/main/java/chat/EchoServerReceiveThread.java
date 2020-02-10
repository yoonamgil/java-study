package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public class EchoServerReceiveThread extends Thread {
	private Socket socket;
	private String nickName;
	ConcurrentHashMap<String,PrintWriter> writerArray;
	List<String> nameList;
	
	
	
	
	public EchoServerReceiveThread(Socket socket,ConcurrentHashMap<String,PrintWriter>writerArray,List<String> nameList) {
		this.socket=socket;
		this.writerArray=writerArray;
		this.nameList=nameList;

		
		
	}
	@Override
	public void run() {
		InetSocketAddress remoteInetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
		int remotePort = remoteInetSocketAddress.getPort();
		String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
		//Scanner scanner = new Scanner(System.in);
		
		EchoServer.log("connected by client[" + remoteHostAddress + ":" + remotePort+ "]");
		
	
		
		try {
			//4. IOStream 생성(받아오기)
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true);
			
			
//			int size= nameList.size();
//			pw.println(Integer.toString(size));
//			for(int i=0;i<size;i++) {
//				pw.println(nameList.get(i));
//			}
			
			
			String name=br.readLine();
			while(nameList.contains(name)){
				pw.println("no");
				name=br.readLine();
			}
			pw.println("ok");
			
			synchronized(nameList) {
			nameList.add(name.trim());
			}
			
			while(true) {
				//5. 데이터 읽기
				String request = br.readLine();
				if(request == null) {
					EchoServer.log("closed by client");
					break;
				}
				String[] tokens = request.split(":");
				if("join".equals(tokens[0])) {
					dojoin(tokens[1],pw);
				}else if("quit".equals(tokens[0])) {
					doQuit(pw);
				}
				
//				else if("//".equals(tokens[1])){
//				
//					if(tokens.length>2) {
//						String k = tokens[2];
//						if(!k.isEmpty())
//							doQuitMessage(k);
//					}
//				}
//				else if("->".equals(tokens[1])) {
//					if(tokens.length>3) {
//						String k = tokens[2];
//						String data=tokens[3];
//						if(k.isEmpty()||data.isEmpty()) {
//							continue;
//						}
//						else {
//							String redata =tokens[3];
//							for(int i=4;i<tokens.length;i++) {
//								data +=":"+tokens[i];
//							}
//							
//							secretMessage(k, redata);
//						}
//					}
//				}else if("/help".equals(tokens[1])) {
//					helpMessage();
//				}
				
				else if("message".equals(tokens[0])) {
					if(tokens.length>1) {	
						 if("//".equals(tokens[1])){
							
							if(tokens.length>2) {
								String k = tokens[2].trim();
								if(!k.isEmpty())
									doQuitMessage(k);
							}
						}
						else if("->".equals(tokens[1])) {
							if(tokens.length>3) {
								String k = tokens[2];
								String data=tokens[3];
								if(k.isEmpty()||data.isEmpty()) {
									continue;
								}
								else {
									String redata =tokens[3];
									for(int i=4;i<tokens.length;i++) {
										data +=":"+tokens[i];
									}
									
									secretMessage(k, redata);
								}
							}
						}else if("/help".equals(tokens[1])) {
							helpMessage();
						}else if("quit".equals(tokens[1])) {
								
						}
						else {
							String data =tokens[1];
							for(int i=2;i<tokens.length;i++) {
								data +=":"+tokens[i];
							}
							
							domessage(data);
						}
					
					}
					
					
					
						
					
					
				}else {
					EchoServer.log("에러: 알수 없는 요청"+tokens[0]+")");
				}
				
			}
		} catch(SocketException e) {
			EchoServer.log("suddenly closed by client");
			synchronized(nameList) {
				nameList.remove(nickName);
				}
			
			String data = nickName +"님이 퇴장하셨습니다";
			broadcast(data);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	} // run 함수의 끝
	
	private void dojoin(String nickName, PrintWriter printWriter) {
		
		this.nickName= nickName;
		printWriter.println("join:ok");
		
		
		String data =nickName+ "님이 참여하였습니다"; 
		addWriter(printWriter);
		printWriter.println("*************************채팅방에 오신걸 환영합니다*************************\n\n"+
				"1. /help 를 치시면 채팅기능과 참여인원에 대하여 알수 있습니다.\n"+
				"2. 귓속말을 하시려면 ->:홍길동: 안녕 ! 이라고 쳐주세요\n"
				+ "3. 채팅방을 종료하시려면 quit을 입력하면 종료됩니다.\n"+""
						+ "4. //:홍길동 이라고 입력하면 홍길동님이 강퇴 당합니다.\n"+
				"5. 욕은 필터링 됩니다! 매너 채팅해주세요!\n\n"+
				"*************************채팅방에 오신걸 환영합니다*************************");
		broadcast(data);
		//ack
		
		printWriter.flush();
		
	}
	
	private void addWriter(PrintWriter writer) {
			synchronized(writerArray) {
				writerArray.put(nickName,writer);
			}
			
			
	}
			
	
	private void broadcast(String data) {
		synchronized(writerArray) {
			Set<String> keys= writerArray.keySet();
			Iterator<String> it = keys.iterator();
			PrintWriter printwriter;
			String temp;
			while(it.hasNext()) {
				temp=it.next();
				printwriter=writerArray.get(temp);
				printwriter.println(data);
				printwriter.flush();
			}
			
		}
	}
	private void secretMessage(String k,String data) {
		Set<String> keys= writerArray.keySet();
		Iterator<String> it = keys.iterator();
		String temp;
		while(it.hasNext()) {
			temp=it.next();
			if(!temp.isEmpty()) {
				if(temp.equals(k)) {
					if(k.equals(nickName)) {
						
					}else {
						PrintWriter pw = writerArray.get(k);
						pw.println(nickName+"님의 귓속말:"+data);
						pw.flush();
					}
				}
			}
		}
	}
	private void doQuitMessage(String name) {
	
		Set<String> keys= writerArray.keySet();
		Iterator<String> it = keys.iterator();
		String temp;
		while(it.hasNext()) {
			temp=it.next();
			if(!temp.isEmpty()) {
				if(temp.equals(name)) {
					if(name.equals(nickName)) {
						
					}else {
						PrintWriter pw = writerArray.get(name);
						pw.println("quit");
						pw.flush();
						synchronized(nameList) {
							nameList.remove(name);
		}		broadcast(name+ "님이 강퇴당하셨습니다");
					}
				}
			}
		}
		
	
		
		
	}
	private void helpMessage() {
		Set<String> keys= writerArray.keySet();
		Iterator<String> it = keys.iterator();
		String temp;
		String data="";
		for(String s: nameList) {
			data+=" "+s;
		}
		while(it.hasNext()) {
			temp=it.next();
			if(!temp.isEmpty()) {
				if(temp.equals(nickName)) {
					PrintWriter pw = writerArray.get(nickName);
					pw.println("**************************************************\n"+
							"1. 귓속말을 하시려면  ->:홍길동:안녕 ! 이라고 쳐주세요\n"
							+ "2. 채팅방을 종료하시려면 quit을 입력하면 종료됩니다.\n"+""
									+ "3. //:홍길동 이라고 입력하면 홍길동님이 강퇴 당합니다.\n"+
							"4. 욕은 필터링 됩니다! 매너 채팅해주세요!\n"+
							"5. 참여인원:"+nameList.size()+" 참여자:"+data+"\n"+
							"**************************************************");
					pw.flush();
				}
			}
		}
		
		
		
	}
	private void domessage(String message) {
		String[] curse= {"시발","개새끼","꺼져","병신","좆",
				"미친","새끼","또라이","엿","씨발","씨1발","ㅅㅂ","ㅄ"};
		String reMessage=message;
		for(String s: curse) {
			if(reMessage.indexOf(s) != -1) {
				reMessage=reMessage.replace(s, "@");
			}
		}
		SimpleDateFormat format = new SimpleDateFormat( "HH:mm:ss" );
		String time = format.format( new Date() );
		
		broadcast(nickName+"("+time+"):"+reMessage);
	}

	private void doQuit(PrintWriter p) {
		
		String data = nickName +"님이 퇴장하셨습니다";
		p.println("quit");
		broadcast(data);
		removeWriter(p);
		synchronized(nameList) {
		nameList.remove(nickName);
		}
		
	}
	
	
	

	@SuppressWarnings("unlikely-arg-type")
	private void removeWriter(PrintWriter writer) {
		synchronized(writerArray) {
		writerArray.remove(writer);
		}
	}
	
	
	

}
