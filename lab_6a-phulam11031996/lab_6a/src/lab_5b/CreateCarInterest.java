package lab_5b;

class CreateCarInterest extends Creator {

	calculateInterest createCalculateInterest(double principal, double rate, int time) {
		return new carInterest(principal, rate, time);
	}

}
