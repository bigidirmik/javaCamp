package dorduncuGunOdevi_eCommerceSystem;

import dorduncuGunOdevi_eCommerceSystem.business.concretes.UserManager;
import dorduncuGunOdevi_eCommerceSystem.core.entities.concretes.User;
import dorduncuGunOdevi_eCommerceSystem.dataAccess.concretes.InMemoryUserDao;

public class Main {

	public static void main(String[] args) {
		
		User user3 = new User(3, "Bilal", "Dýrmýk", "bilal@bilal.com", "123456");
		
		User user4 = new User(4, "Hikmet", "Dýrmýk", "hikmet@hikmet.com", "654321");
		
		UserManager manager = new UserManager(new InMemoryUserDao());
		
		manager.register(user3);
		System.out.println("----------------------");
		manager.register(user4);
		
		System.out.println("-------------------------------------------------------");
		
		manager.loginWithThirdParty("bilal@bilal.com");
		
		

	}

}
