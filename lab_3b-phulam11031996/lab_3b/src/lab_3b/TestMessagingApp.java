package lab_3b;

public class TestMessagingApp {

	public static void main(String[] args) {
		MessageServiceInjector email = new EmailServiceInjector();
		MessageServiceInjector sms = new SMSServiceInjector();

		email.getCustomer().processMessages("Hi John", "john@abc.com");
		sms.getCustomer().processMessages("Hi Dude", "dude@abc.com");

	}

}