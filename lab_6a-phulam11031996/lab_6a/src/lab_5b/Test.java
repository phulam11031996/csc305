package lab_5b;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Test {


	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new
			ByteArrayOutputStream();

	@org.junit.Test
	public void TestCarInterest() {
		System.setOut(new PrintStream(outputStreamCaptor));

		Creator car = new CreateCarInterest();
		carInterest carInterest  = (lab_5b.carInterest) car.createCalculateInterest(30000, 0.05, 10);
		carInterest.displayInterest();

		assertEquals("45000.0", outputStreamCaptor.toString()
				.trim());

	}

	@org.junit.Test
	public void TestHomeInterest() {
		System.setOut(new PrintStream(outputStreamCaptor));


		Creator home = new CreateHomeInterest();
		homeInterest homeInterest  = (lab_5b.homeInterest) home.createCalculateInterest(300000, 0.05, 10);
		homeInterest.displayInterest();


		assertEquals("494102.849307084", outputStreamCaptor.toString()
				.trim());

	}
}
