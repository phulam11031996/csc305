package lab_5b;

class Driver {

	public static void main(String[] args) {

		Creator car = new CreateCarInterest();
		carInterest carInterest  = (lab_5b.carInterest) car.createCalculateInterest(30000, 0.05, 10);
		carInterest.displayInterest();


		Creator home = new CreateHomeInterest();
		homeInterest homeInterest  = (lab_5b.homeInterest) home.createCalculateInterest(300000, 0.05, 10);
		homeInterest.displayInterest();

	}

}
