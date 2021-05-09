package dorduncuGunOdevi_eCommerceSystem.business.concretes;

import dorduncuGunOdevi_eCommerceSystem.business.abstracts.VerificationService;

public class VerificationManager implements VerificationService{

	private static String verificationCode = "AJ54K0M";
	
	@Override
	public void sendActivation(String email) {
		System.out.println("Lütfen doðrulama için " + email + " adresinizi kontrol ediniz.");
		System.out.println("Doðrulama kodunuz : " + verificationCode);
	}

	@Override
	public void activateEmail(String verificationCode) {
		System.out.println("Hesabýnýz baþarýyla doðrulandý.");
	}

}
