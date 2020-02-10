package exception;

public class Exception {

	public Exception(String string) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int a= 10;
		int b= 10- a; 
		
		System.out.println("some codes0");
		
		try {
			 System.out.println("some codes1");
			 int result =(1+2+3)/b;
			 System.out.println("some codes2");
			 
		}
		catch(ArithmeticException ex){ 
			 //1. 사과
			 System.out.println("미안합니다........");
			 //2. 로그 남기기(파일,DB)
			 System.out.println(ex);
			 //3. 정상 종료 
			 return ;  // 리턴문을 작성하였어도 finally문은 무조건 실행된다. 
		}
		finally { // 옵션 
			 System.out.println("some codes4");
		}
		
		System.out.println("some codes5");
	}

}
