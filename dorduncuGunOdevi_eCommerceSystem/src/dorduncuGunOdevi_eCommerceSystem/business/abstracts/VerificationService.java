package dorduncuGunOdevi_eCommerceSystem.business.abstracts;

public interface VerificationService {
	void sendActivation(String email);
	void activateEmail(String verificationCode);
}
