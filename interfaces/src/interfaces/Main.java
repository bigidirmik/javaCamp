package interfaces;

public class Main {

	public static void main(String[] args) {
		
		Logger[] loggers = {new EmailLogger(), new DatabaseLogger(), new FileLogger(), new SmsLogger()};
		
		CustomerManager customerManager = new CustomerManager(loggers);
		
		Customer bilal = new Customer(1, "Bilal", "Dýrmýk");
		
		customerManager.add(bilal);

	}

}
