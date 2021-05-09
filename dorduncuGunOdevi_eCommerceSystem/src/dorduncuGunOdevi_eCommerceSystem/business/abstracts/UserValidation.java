package dorduncuGunOdevi_eCommerceSystem.business.abstracts;

import dorduncuGunOdevi_eCommerceSystem.core.entities.concretes.User;

public interface UserValidation {
	boolean validateName (String firstName, String lastName);
	boolean validateEmail(String email);
	boolean validatePassword(String password);
	boolean isEmailExist(String email);
	
	boolean allValidatesInOne(User user);
}
