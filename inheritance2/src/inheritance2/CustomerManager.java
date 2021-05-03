package inheritance2;

public class CustomerManager {
	
	public void add(Logger logger) { // virgül ile customer sonra logger da yapabiliyoruz
		// müþteri ekleme kodlarý
		System.out.println("Müþteri eklendi");
		
		// DatabaseLogger logger = new DatabaseLogger();
		// bir iþ sýnýfý baþka bir sýnýfý kullanacak ise somutunu kullanamaz
		// bunun yerine parametre veririz ve new'lemeye gerek kalmaz
		
		logger.log(); // parametrede bize logger'ýný söylemesini isteriz ve o log otomatik kullanýlýr
		
	}
	
}
