package lab_3a;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JUnitTestLab3a {
	private LocalTime time1 = LocalTime.of(14,0,0);  
	private LocalTime time2 = LocalTime.of(16,0,0);  
	private int childAge = 12;
	private int seniorAge = 62;

	@Test
	void badArgumentsForConstructor() {
		assertThrows(IllegalArgumentException.class, () -> {
			MovieTicketPriceCalculator mtpc = new MovieTicketPriceCalculator(time2, time1, childAge, seniorAge);
		});


	}

	@Test
	void computeDiscountChildAge() {
		MovieTicketPriceCalculator mtpc = new MovieTicketPriceCalculator(time1, time2, childAge, seniorAge);
		int res = mtpc.computeDiscount(6);
		assertEquals(300, res);
	}

	@Test
	void computeDiscountNormalAge() {
		MovieTicketPriceCalculator mtpc = new MovieTicketPriceCalculator(time1, time2, childAge, seniorAge);
		int res = mtpc.computeDiscount(40);
		assertEquals(0, res);
	}

	@Test
	void computeDiscountSeniorAge() {
		MovieTicketPriceCalculator mtpc = new MovieTicketPriceCalculator(time1, time2, childAge, seniorAge);
		int res = mtpc.computeDiscount(63);
		assertEquals(400, res);

	}

	@Test
	void computePriceForMatineeHour() {
		MovieTicketPriceCalculator mtpc = new MovieTicketPriceCalculator(time1, time2, childAge, seniorAge);
		LocalTime testTime = LocalTime.of(15,0,0);  
		int res = mtpc.computePrice(testTime, 65);
		assertEquals(2000, res);
	}

	@Test
	void computePriceForNormalHour() {
		MovieTicketPriceCalculator mtpc = new MovieTicketPriceCalculator(time1, time2, childAge, seniorAge);
		LocalTime testTime = LocalTime.of(4,0,0);  
		int res = mtpc.computePrice(testTime, 65);
		assertEquals(2300, res);
	}

}
