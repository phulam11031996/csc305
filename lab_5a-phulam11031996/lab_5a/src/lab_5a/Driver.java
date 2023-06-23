package lab_5a;

class Driver {

	public static void main(String[] args) {

		calculateInterest calculateInterest;
		
		calculateInterest = new carInterest(30000, 0.05, 10);
		calculateInterest.displayInterest();

		calculateInterest = new homeInterest(300000, 0.05, 10);
		calculateInterest.displayInterest();
		
	}

}
