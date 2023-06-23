package lab_5b;


public class carInterest extends calculateInterest{
	
	public carInterest(double principal, double rate, int time) {
		super(principal, rate, time);
	}
	
	@Override
	public void accept(InterestVisitor obj) {
		obj.visitCarInterest(this);
	}

}
