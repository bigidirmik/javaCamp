package ucuncuGunOdevi;

public class Main {

	public static void main(String[] args) {
		
		UserManager userManager = new UserManager(new DatabaseLogger());
		
		Instructor egitmen = new Instructor(1, 1, "Engin", "Demiroð", "engin@engin.com", 12345, "cokGizliAdminSifresi123");
		
		Student ogrenci = new Student(2, 2, "Bilal", "Dýrmýk", "bigi@bigi.com", 67890, 43);
		
		User[] users = {egitmen,ogrenci};
		
		for(User user : users) {
			userManager.add(user);
		}
		
	}

}
