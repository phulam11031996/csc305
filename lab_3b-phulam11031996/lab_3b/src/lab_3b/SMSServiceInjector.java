package lab_3b;

public class SMSServiceInjector implements MessageServiceInjector{

	private Customer costomer = new MessagingApp(new SMSService());

	@Override
	public Customer getCustomer() {
		return this.costomer;
	}

}
