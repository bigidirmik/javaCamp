package dorduncuGunOdevi_coffeeApp;

import Abstract.BaseCustomerManager;
import Adapters.MernisServiceAdapter;
import Concrete.NeroCustomerManager;
import Concrete.StarbucksCustomerManager;
import Entities.Customer;

public class Main {

	public static void main(String[] args) {
		
		// Doðrulamasýz
		BaseCustomerManager neroCustomerManager = new NeroCustomerManager();
		neroCustomerManager.save(new Customer(1, "Bigi", "Dýrmýk", 1993, 12345678901L));
		
		
		// Mernis Doðrulamalý
		BaseCustomerManager starbucksCustomerManager = new StarbucksCustomerManager(new MernisServiceAdapter());
		starbucksCustomerManager.save(new Customer(1, "Bilal", "Dýrmýk", 1993, 12345678901L)); 
		
		// TC No'yu bilerek yanlýþ yazdým.
		
	}

}
