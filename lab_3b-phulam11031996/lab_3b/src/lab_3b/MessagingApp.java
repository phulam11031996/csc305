package lab_3b;

public class MessagingApp implements Customer {

	private MessageService message;

	public MessagingApp(EmailService email) {
		this.message = email;
	}

	public MessagingApp(SMSService sms) {
		this.message = sms;
	}

	@Override
	public void processMessages(String msg, String rec) {
		message.sendMessage(msg, rec);
	}

}


