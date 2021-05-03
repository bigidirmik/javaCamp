package inheritance;

public class Main {

	public static void main(String[] args) {
		
		
		IndividualCustomer bilal = new IndividualCustomer();
		bilal.customerNumber = "12345";
		
		
		CorporateCustomer hepsiBurada = new CorporateCustomer();
		hepsiBurada.customerNumber = "67890";
		
		
		UnionCustomer disk = new UnionCustomer();
		disk.customerNumber = "01928";
		
		
		CustomerManager customerManager = new CustomerManager();
		
		Customer[] customers = {bilal, hepsiBurada, disk};
		
		customerManager.AddMultiple(customers);
		
	}

}
