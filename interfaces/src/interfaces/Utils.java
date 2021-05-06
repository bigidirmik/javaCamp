package interfaces;

public class Utils {
	
	// static yaptýk, çünkü kullanacaðýmýz metot içinde new'lemek istemiyoruz
	// static yapýnca direkt sýnýfýn ismini vererek kullanabiliriz.
	public static void runLoggers(Logger[] loggers, String message) {
		for(Logger logger : loggers) {
			logger.log(message);
		}
	}
	
}
