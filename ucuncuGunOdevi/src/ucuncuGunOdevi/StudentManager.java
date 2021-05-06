package ucuncuGunOdevi;

public class StudentManager extends UserManager {
	
	public StudentManager(BaseLogger logger) {
		super(logger);
		// TODO Auto-generated constructor stub
	}

	
	public void studentOfTheMonth(User user) {
		System.out.println(user.getId() + "Ayýn öðrencisi getirildi.");
	}

}
