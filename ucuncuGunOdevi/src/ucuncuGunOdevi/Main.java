package ucuncuGunOdevi;

public class Main {

	public static void main(String[] args) {
		
		UserManager userManager = new UserManager(new DatabaseLogger());
		
		User egitmen = new User(1, "Engin", "Demiroð", "engin@engin.com", 12345);
		
		User ogrenci = new User(2, "Bilal", "Dýrmýk", "bigi@bigi.com", 67890);
		
		User[] users = {egitmen,ogrenci};
		
		for(User user : users) {
			userManager.add(user);
		}
		

	}

}
