package lab_5a;

public class homeInterest extends calculateInterest {

	public homeInterest(double principal, double rate, int time) {
		super(principal, rate, time);
	}

	@Override
	void displayInterest() {
		super.showInterestStrategy = new showHomeInterest();
		super.showInterestStrategy.showInterest(super.principal, super.annual_rate, super.time, super.N);
	}

}
