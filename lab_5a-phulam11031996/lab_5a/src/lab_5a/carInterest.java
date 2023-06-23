package lab_5a;

public class carInterest extends calculateInterest {
	
	
	public carInterest(double principal, double rate, int time) {
		super(principal, rate, time);
	}

	void displayInterest() {
		super.showInterestStrategy = new showCarInterest();
		super.showInterestStrategy.showInterest(super.principal, super.annual_rate, super.time, super.N);
	}

}
