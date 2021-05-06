package interfaces;

public class CustomerManager {
	
	// Dependency Injection
	
	private Logger[] loggers;
	
	public CustomerManager(Logger[] loggers) {
		this.loggers = loggers;
	}

	// loosly - tightly coupled : gevþek ve katý baðlýlýk
	
	// add metodu içine DatabaseLogger olarak new lemek katý baðlýlýktýr. ileride tek tek deðiþtirmek zorunda kalabiliriz.
	// gevþek baðlýlýk üzerine bir sistem kurmamýz gereklidir
	
	
	public void add(Customer customer) {
		System.out.println("Müþteri eklendi : " + customer.getFirstName());
		Utils.runLoggers(loggers, customer.getFirstName());
	}
	
	public void delete(Customer customer) {
		System.out.println("Müþteri silindi : " + customer.getFirstName());
		Utils.runLoggers(loggers, customer.getFirstName());
	}

}
