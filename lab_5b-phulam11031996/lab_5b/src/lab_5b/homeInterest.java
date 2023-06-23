package lab_5b;

public class homeInterest extends calculateInterest{

	public homeInterest(double principal, double rate, int time) {
		super(principal, rate, time);
	}

	@Override
	public void accept(InterestVisitor obj) {
		obj.visitHomeInterest(this);
	}


}
