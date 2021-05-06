package interfaces;

public class Utils {
	
	// static yapt�k, ��nk� kullanaca��m�z metot i�inde new'lemek istemiyoruz
	// static yap�nca direkt s�n�f�n ismini vererek kullanabiliriz.
	public static void runLoggers(Logger[] loggers, String message) {
		for(Logger logger : loggers) {
			logger.log(message);
		}
	}
	
}
