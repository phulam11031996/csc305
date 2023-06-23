package lab_3b;

public class EmailService implements MessageService {

	@Override
	public void sendMessage(String message, String receiver){
		System.out.println("Email sent to "+receiver+ " with Message: "+message);
	}
}