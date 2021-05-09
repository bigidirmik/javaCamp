package dorduncuGunOdevi_eCommerceSystem.dataAccess.abstracts;

import java.util.List;

import dorduncuGunOdevi_eCommerceSystem.core.entities.concretes.User;

public interface UserDao {
	void add(User user);
	void update(User user);
	void delete(User user);
	
	User get(int id);
	User getByMail(String email);
	List<User> getAll();
}
