/**
 * 
 */
package lab_5a;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;


/**
 * @author phu
 *
 */
public class Test {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new
			ByteArrayOutputStream();

	@org.junit.Test
	public void TestCarInterest() {
		System.setOut(new PrintStream(outputStreamCaptor));

		calculateInterest calculateInterest;
		calculateInterest = new carInterest(30000, 0.05, 10);
		calculateInterest.displayInterest();

		assertEquals("45000.0", outputStreamCaptor.toString()
				.trim());
	}

	@org.junit.Test
	public void TestHomeInterest() {
		System.setOut(new PrintStream(outputStreamCaptor));

		calculateInterest calculateInterest;
		calculateInterest = new homeInterest(300000, 0.05, 10);
		calculateInterest.displayInterest();

		assertEquals("494102.849307084", outputStreamCaptor.toString()
				.trim());
	}

}
