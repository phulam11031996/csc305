package lab_3b;

public interface MessageService {

	/**
	   * Send email with message to receiver.
	   *
	   * @param message message contained in the email (non-null)
	   * @param receiver email address (non-null)
	   */
	void sendMessage(String message, String receiver);

}