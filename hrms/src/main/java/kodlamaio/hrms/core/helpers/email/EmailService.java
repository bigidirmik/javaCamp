package kodlamaio.hrms.core.helpers.email;

public interface EmailService {
	
	public void sendLink(String email);
	public String sendCode();

}
