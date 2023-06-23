package lab_3b;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class JUnitTestLab3b {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new
			ByteArrayOutputStream();

	@Before
	public void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	void testSMS() {
		System.setOut(new PrintStream(outputStreamCaptor));
		MessageServiceInjector sms = new SMSServiceInjector();
		sms.getCustomer().processMessages("Hi Dude", "dude@abc.com");

		assertEquals("SMS sent to dude@abc.com with Message: Hi Dude", outputStreamCaptor.toString()
				.trim());
	}

	@Test
	void testEmail() {
		System.setOut(new PrintStream(outputStreamCaptor));
		MessageServiceInjector sms = new EmailServiceInjector();
		sms.getCustomer().processMessages("Hi John", "john@abc.com");

		assertEquals("Email sent to john@abc.com with Message: Hi John", outputStreamCaptor.toString()
				.trim());
	}


	@After
	public void tearDown() { System.setOut(standardOut);
	}

}
