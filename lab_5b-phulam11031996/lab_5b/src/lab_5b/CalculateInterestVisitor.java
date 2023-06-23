package lab_5b;

class CalculateInterestVisitor implements InterestVisitor{

	public void visitCarInterest(carInterest car) {
		System.out.println(car.principal * (1 + car.annual_rate * car.time));
	}

	public void visitHomeInterest(homeInterest home) {
		System.out.println(home.principal * Math.pow((1 + home.annual_rate/home.N), home.N * home.time));
	}

}
