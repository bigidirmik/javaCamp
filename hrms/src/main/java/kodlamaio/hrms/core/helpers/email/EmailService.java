package kodlamaio.hrms.core.helpers.email;

public interface EmailService {
	
	void sendLink(String email);
	String sendCode();

}
