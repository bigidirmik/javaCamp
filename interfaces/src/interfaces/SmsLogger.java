package interfaces;

// mirasta extends yaz�yorduk, implemente s�z konusu olunca ise implements yaz�l�r.
// Add unimplemented method diyerek tamaml�yoruz
public class SmsLogger implements Logger {

	@Override
	public void log(String message) {
		
		System.out.println("SMS g�nderildi : " + message);
		
	} 
	
	
	
}
