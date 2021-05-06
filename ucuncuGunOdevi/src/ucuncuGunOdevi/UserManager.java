package ucuncuGunOdevi;

public class UserManager {

	
	private BaseLogger logger;
	
	public UserManager(BaseLogger logger) {
		this.logger = logger;
	}
	
	
	public void add(User user) {
		System.out.println( user.getEmail() + " eklendi.");
		this.logger.log("logland�.");
	}

	public void update(User user) {
		System.out.println(user.getEmail() + " g�ncellendi.");
		this.logger.log("logland�.");
	}

	public void delete(User user) {
		System.out.println(user.getEmail() + " silindi.");
		this.logger.log("logland�.");
	}

	public void list(User[] users) {
		for(User user : users) {
			System.out.println(user.getEmail() + " listelendi.");
			return;
		}
		this.logger.log("logland�.");
	}

}
