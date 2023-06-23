package lab_5b;


public class carInterest extends calculateInterest{
	
	
	public carInterest(double principal, double rate, int time) {
		super(principal, rate, time);
	}

	@Override
	void displayInterest() {
		System.out.println(super.principal * (1 + super.annual_rate * super.time));
	}

}
