package prob6;

import java.util.Scanner;

public class Prob06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	
		while( true ) {
			System.out.print(">>");
			String expr = scanner.nextLine();
			
			if("quit".equals(expr)) {
				break; 
			}
			
			
			String[] tokens = expr.split(" ");
			
			if(tokens.length !=3) {
				
				System.out.println("지원하지 않는 연산식입니다.");
				continue;
			}
			
			int lValue = Integer.parseInt(tokens[0]);
			int rValue = Integer.parseInt(tokens[2]);
			int result; 
			double result2;
			
			if("+".equals(tokens[1])){
				Add add = new Add();
				add.setValue(lValue,rValue);
				result = add.calculate();
				System.out.println(">>"+ result );
			}
			else if("-".equals(tokens[1])){
				Sub sub = new Sub();
				sub.setValue(lValue,rValue);
				result = sub.calculate();
				System.out.println(">>"+ result );
			}
			else if("/".equals(tokens[1])){
				Div div = new Div();
				div.setValue(lValue,rValue);
				result2 = div.calculate();
				System.out.println(">>"+ result2 );
			}
			else if("*".equals(tokens[1])){
				Mul mul = new Mul();
				mul.setValue(lValue,rValue);
				result = mul.calculate();
				System.out.println(">>"+ result );
			}
			else {
				
				System.out.println("지원하지 않는 연산식입니다.");
				continue;
			}
			
			
		}
		
		scanner.close();
	}

}
