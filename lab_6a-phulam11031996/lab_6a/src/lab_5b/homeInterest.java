package lab_5b;

public class homeInterest extends calculateInterest{

	public homeInterest(double principal, double rate, int time) {
		super(principal, rate, time);
	}

	@Override
	void displayInterest() {
		System.out.println(super.principal * Math.pow((1 + super.annual_rate/super.N), super.N * super.time));
	}

}
