package prob5;

public class Account {

	private String accountNo; 
	
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	private int balance; 
	
	public Account(String accountNo ) {
		this.accountNo=accountNo;
	
		System.out.println(this.accountNo+"계좌가 개설되었습니다.");
	}
	
	public void save(int balance) {
		this.balance += balance;
		System.out.println(accountNo+"계좌에 "+ balance +"만원이 입금되었습니다.");
		
	}
	public void deposit(int balance) {
		
		if(this.balance<balance) {
			
			System.out.println("잔액이 부족합니다. 현재 잔액:"+ this.balance);
			return; 
		}
		
		this.balance -= balance;
		System.out.println(accountNo+"계좌에 "+ balance +"만원이 출금되었습니다.");
	}
	
}