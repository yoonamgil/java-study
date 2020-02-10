package chat.client.win;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;



public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	
	private Socket socket;
	private String name;
	private static  PrintWriter pw;

	public ChatWindow(String name, Socket socket) {
		this.name=name;
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.socket= socket;
	}

	public void show() {
		
		// 1. UI 초기화 작업 
		
		
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() { // 일회용 클래스
			

			@Override
			public void keyReleased(KeyEvent e) {
				char KeyCode=e.getKeyChar();
				if(KeyCode== KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);
		frame.pack();
		
		
		   // 3. 쓰레드 생성 작업 
	    try {
	    	
	    	pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true);// true 를 안하면 버퍼가 완전히 차지 않으면 바로 가지 않는다. 
			new ChatClientThread(name,socket).start();
		
	    } catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	 
	    
		
		
	}
	
	private void sendMessage() {
		
		String message =textField.getText();
		
		// 소켓을 통해 메세지가 온경우 
		

		if("quit".equals(message)){
			pw.println(message);
			textField.setText("");
			textField.requestFocus();
			//System.exit(0);
			return;
		}
		else if(message ==null) {
//			System.out.println("오류발생");
//			
//			return;
		}else {
			textField.setText("");
			textField.requestFocus();
			pw.println("message:"+message);
		}
	
	}
	
	
	
	public class ChatClientThread extends Thread{
		private Socket socket;
		String nickName;
		public ChatClientThread(String name, Socket socket) {
			this.socket=socket;
			this.nickName = name;
		}
		@Override
		public void run() {
			try {
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"utf-8"); // byte -> char 
		    BufferedReader br = new BufferedReader(isr); // char- > 체인 보조 스트림으로 만들어 성능을 향상시킨다. 
			  while(true) {
					String data = br.readLine();
					
				
					if(data ==null) {
						System.out.println("오류로 종료합니다.");
						break;
					}
					if("quit".equals(data)) {
						break;
					}
					System.out.println(data);
					textArea.append(data); // 텍스트창에 넣는 방법 
					textArea.append("\n");
					
					
					
				}
			  
			}catch(Exception e){
				

		      }finally {
		    	  try {
		    		 try {
						socket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	  System.exit(0);
		      }
		}
		
	}
	
	
}
