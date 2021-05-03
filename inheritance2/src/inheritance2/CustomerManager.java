package inheritance2;

public class CustomerManager {
	
	public void add(Logger logger) { // virg�l ile customer sonra logger da yapabiliyoruz
		// m��teri ekleme kodlar�
		System.out.println("M��teri eklendi");
		
		// DatabaseLogger logger = new DatabaseLogger();
		// bir i� s�n�f� ba�ka bir s�n�f� kullanacak ise somutunu kullanamaz
		// bunun yerine parametre veririz ve new'lemeye gerek kalmaz
		
		logger.log(); // parametrede bize logger'�n� s�ylemesini isteriz ve o log otomatik kullan�l�r
		
	}
	
}
