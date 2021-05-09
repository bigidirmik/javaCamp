package dorduncuGunOdevi_eCommerceSystem.business.concretes;

import java.util.List;

import dorduncuGunOdevi_eCommerceSystem.business.abstracts.ThirdPartyLoginService;
import dorduncuGunOdevi_eCommerceSystem.business.abstracts.UserService;
import dorduncuGunOdevi_eCommerceSystem.business.abstracts.UserValidation;
import dorduncuGunOdevi_eCommerceSystem.business.abstracts.VerificationService;
import dorduncuGunOdevi_eCommerceSystem.core.entities.concretes.User;
import dorduncuGunOdevi_eCommerceSystem.dataAccess.abstracts.UserDao;
import dorduncuGunOdevi_eCommerceSystem.dataAccess.concretes.InMemoryUserDao;

public class UserManager implements UserService {

	private UserDao userDao;
	UserValidation userValidation = new UserValidator(new InMemoryUserDao());
	VerificationService verificationService = new VerificationManager();
	
	ThirdPartyLoginService loginService = new GoogleLoginManagerAdapter();
	
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	
	@Override
	public void register(User user) {
		if (userValidation.allValidatesInOne(user)){
				this.userDao.add(user);
				this.verificationService.sendActivation(user.getEmail());
				this.verificationService.activateEmail(null);
			}
		else {
				System.out.println("Lütfen tekrar deneyin!");
			}
	}
	
	@Override
	public void login(String email, String password) {
		User user = this.userDao.getByMail(email);
		if(user.getEmail()!=email) {
			System.out.println("Hatalý e-posta adresi!");
		}
		if(user.getPassword()!=password) {
			System.out.println("Hatalý parola!");
		}
		else {
			System.out.println("Hoþgeldin " + user.getFirstName());
		}
	}
	
	@Override
	public void loginWithThirdParty(String email) {
		User user = this.userDao.getByMail(email);
		if(user.getEmail()!=email) {
			System.out.println("Kullanýcý mevcut deðil!");
		}
		else {
			loginService.login(email);
			System.out.println("Hoþgeldin " + user.getFirstName() + "!");
		}
	}

	@Override
	public void update(User user) {
		if (userValidation.validateName(user.getFirstName(), user.getLastName()) &&
			userValidation.validateEmail(user.getEmail()) &&
			userValidation.validatePassword(user.getPassword())
			){
				this.userDao.update(user);
			}
		else {
			System.out.println("Hatalý kullanýcý bilgisi!");
		}
	}

	@Override
	public void delete(User user) {
		this.userDao.delete(user);
		System.out.println(user.getFirstName() + " silindi.");
	}

	@Override
	public User get(int id) {
		this.userDao.get(id);
		return null;
	}

	@Override
	public List<User> getAll() {
		return this.userDao.getAll();
	}



	
	
}
