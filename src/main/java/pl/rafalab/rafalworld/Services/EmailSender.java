package pl.rafalab.rafalworld.Services;

public interface EmailSender {

	void sendEmail(String to, String subject, String text);
	
}
