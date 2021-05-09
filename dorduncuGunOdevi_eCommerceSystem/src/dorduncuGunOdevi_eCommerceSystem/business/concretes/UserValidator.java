package dorduncuGunOdevi_eCommerceSystem.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dorduncuGunOdevi_eCommerceSystem.business.abstracts.UserValidation;
import dorduncuGunOdevi_eCommerceSystem.core.entities.concretes.User;
import dorduncuGunOdevi_eCommerceSystem.dataAccess.abstracts.UserDao;

public class UserValidator implements UserValidation {

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	private UserDao userDao;

	public UserValidator(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean validateName(String firstName, String lastName) {
		if (firstName.length() > 2 && lastName.length() > 2) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean validateEmail(String email) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		if (matcher.find()) {
			matcher.find();
			return true;
		} else {
			System.out.println("Hatalý email deseni girdiniz!");
			return false;
		}
	}

	@Override
	public boolean validatePassword(String password) {
		if (password.length() > 5) {
			return true;
		} else {
			System.out.println("Þifre en az 6 karakter olmalý!");
			return false;
		}
	}

	@Override
	public boolean isEmailExist(String email) {
		User user = userDao.getByMail(email);
		if (user.getEmail()==email) {
			System.out.println("Email adresi kullanýlmýþ!");
			return true;
		}
		return false;
	}

	@Override
	public boolean allValidatesInOne(User user) {
		if (validateName(user.getFirstName(), user.getLastName()) &&
			validateEmail(user.getEmail()) &&
			validatePassword(user.getPassword()) &&
			!isEmailExist(user.getEmail())) {
			return true;
		}
		return false;
	}

}
