package lab_5a;

class showHomeInterest implements showInterestStrategy {

	public void showInterest(double principal, double rate, int time, int N) {
		System.out.println(principal * Math.pow((1 + rate/N), N * time));
	}

}