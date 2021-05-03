package ucuncuGunOdevi;

public class UserManager {

	
	private BaseLogger logger;
	
	public UserManager(BaseLogger logger) {
		this.logger = logger;
	}
	
	
	public void add(User user) {
		System.out.println(user.getFullName() + " eklendi.");
		this.logger.log("logland�.");
	}

	public void update(User user) {
		System.out.println(user.getFullName() + " g�ncellendi.");
		this.logger.log("logland�.");
	}

	public void delete(User user) {
		System.out.println(user.getFullName() + " silindi.");
		this.logger.log("logland�.");
	}

	public void list(User[] users) {
		for(User user : users) {
			System.out.println(user.getFullName() + " listelendi.");
			return;
		}
		this.logger.log("logland�.");
	}

}
