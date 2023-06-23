package lab_5a;

class showCarInterest implements showInterestStrategy {

	@Override
	public void showInterest(double principal, double rate, int time, int N) {
		System.out.println(principal * (1 + rate * time));
	}

}
