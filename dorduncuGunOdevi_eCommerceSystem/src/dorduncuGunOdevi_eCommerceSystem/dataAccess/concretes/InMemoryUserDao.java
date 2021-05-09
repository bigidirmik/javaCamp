package dorduncuGunOdevi_eCommerceSystem.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dorduncuGunOdevi_eCommerceSystem.core.entities.concretes.User;
import dorduncuGunOdevi_eCommerceSystem.dataAccess.abstracts.UserDao;

public class InMemoryUserDao implements UserDao {

	User user1 = new User(1, "Bilal", "Dýrmýk", "bilal@bilal.com", "123456");
	User user2 = new User(2, "Hikmet", "Dýrmýk", "higi@higi.com", "654321");
	
	private List<User> users = new ArrayList<User>();
	

	public InMemoryUserDao() {
		users.add(user1);
	}
	
	@Override
	public void add(User user) {
		users.add(user);
		System.out.println("InMemory ile eklendi : " + user.getFirstName());
	}

	@Override
	public void update(User user) {
		System.out.println("InMemory ile güncellendi : " + user.getFirstName());
	}

	@Override
	public void delete(User user) {
		System.out.println("InMemory ile silindi : " + user.getFirstName());
	}

	@Override
	public User get(int id) {
		for (User user : users) {
			return user;
		}
		return null;
	}

	@Override
	public User getByMail(String email) {
		for (User user : users) {
				return user;
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		return users;
	}

}
