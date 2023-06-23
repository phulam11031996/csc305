package lab_5b;

class CreateHomeInterest extends Creator {

	calculateInterest createCalculateInterest(double principal, double rate, int time) {
		return new homeInterest(principal, rate, time);
	}

}
