package prob04;

public class Depart extends Employee{
	
	private String departmen;
	
	public Depart(String name, int salary,String departmen) {
		super(name,salary);
		this.departmen=departmen;
		
	}
	
	public void getInformation() {
		
		System.out.println("이름: "+getName()+"연봉 :"+getSalary()+" 부서:"+this.departmen);
	}
}
