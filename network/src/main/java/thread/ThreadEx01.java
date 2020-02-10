package thread;

public class ThreadEx01 {

	public static void main(String[] args) {
		Thread thread= new DigitalThread();
		
		
		thread.start();
		
		for(char c='a';c<='z';c++) {
			System.out.print(c);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
