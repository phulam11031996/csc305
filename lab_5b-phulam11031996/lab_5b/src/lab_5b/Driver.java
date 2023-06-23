package lab_5b;

class Driver {

	public static void main(String[] args) {
		calculateInterest homeInterest = new homeInterest(300000, 0.05, 10);
		calculateInterest carInterest = new carInterest(30000, 0.05, 10);
		
		homeInterest.accept(new CalculateInterestVisitor());
		carInterest.accept(new CalculateInterestVisitor());
		
	}

}
