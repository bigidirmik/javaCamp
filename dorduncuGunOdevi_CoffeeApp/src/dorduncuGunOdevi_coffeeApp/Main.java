package dorduncuGunOdevi_coffeeApp;

import Abstract.BaseCustomerManager;
import Adapters.MernisServiceAdapter;
import Concrete.NeroCustomerManager;
import Concrete.StarbucksCustomerManager;
import Entities.Customer;

public class Main {

	public static void main(String[] args) {
		
		// Do�rulamas�z
		BaseCustomerManager neroCustomerManager = new NeroCustomerManager();
		neroCustomerManager.save(new Customer(1, "Bigi", "D�rm�k", 1993, 12345678901L));
		
		
		// Mernis Do�rulamal�
		BaseCustomerManager starbucksCustomerManager = new StarbucksCustomerManager(new MernisServiceAdapter());
		starbucksCustomerManager.save(new Customer(1, "Bilal", "D�rm�k", 1993, 12345678901L)); 
		
		// TC No'yu bilerek yanl�� yazd�m.
		
	}

}
