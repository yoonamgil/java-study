package thread;

public class UppercaseAlphabet {
	public void print() {
		for(char c= 'A';c<='Z';c++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(c);
		}
	}


}
