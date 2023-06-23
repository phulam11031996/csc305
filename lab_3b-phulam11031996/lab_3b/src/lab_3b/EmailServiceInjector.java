package lab_3b;

public class EmailServiceInjector implements MessageServiceInjector{
	
	private Customer customer = new MessagingApp(new EmailService());

	@Override
	public Customer getCustomer() {
		return this.customer;
	}

	
}
