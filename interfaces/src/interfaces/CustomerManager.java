package interfaces;

public class CustomerManager {
	
	// Dependency Injection
	
	private Logger[] loggers;
	
	public CustomerManager(Logger[] loggers) {
		this.loggers = loggers;
	}

	// loosly - tightly coupled : gev�ek ve kat� ba�l�l�k
	
	// add metodu i�ine DatabaseLogger olarak new lemek kat� ba�l�l�kt�r. ileride tek tek de�i�tirmek zorunda kalabiliriz.
	// gev�ek ba�l�l�k �zerine bir sistem kurmam�z gereklidir
	
	
	public void add(Customer customer) {
		System.out.println("M��teri eklendi : " + customer.getFirstName());
		Utils.runLoggers(loggers, customer.getFirstName());
	}
	
	public void delete(Customer customer) {
		System.out.println("M��teri silindi : " + customer.getFirstName());
		Utils.runLoggers(loggers, customer.getFirstName());
	}

}
