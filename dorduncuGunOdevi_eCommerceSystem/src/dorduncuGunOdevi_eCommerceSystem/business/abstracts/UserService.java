package dorduncuGunOdevi_eCommerceSystem.business.abstracts;

import java.util.List;

import dorduncuGunOdevi_eCommerceSystem.core.entities.concretes.User;

public interface UserService {
	void register(User user);
	void login(String email, String password);
	void loginWithThirdParty(String email);
	
	void update(User user);
	void delete(User user);
	
	User get(int id);
	List<User> getAll();
}
