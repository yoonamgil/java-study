package prob6;

public class Div {
	int a;
	int b;
	
	void setValue(int a, int b) {
		this.a =a;
		this.b =b;
	}
	double calculate() {
		double div=(double) this.a / this.b;
		
		return div;
	}
}
