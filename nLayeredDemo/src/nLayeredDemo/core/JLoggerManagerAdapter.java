package nLayeredDemo.core;

import nLayeredDemo.jLogger.JLoggerManager;

public class JLoggerManagerAdapter implements LoggerService {

	@Override
	public void logToSystem(String message) {
		
		// Core katmanýnda kendi Service'imizi ve Adapter class'ýný yazýp yukarýdaki gibi implements yaptýk.
		// Ardýndan overrride edilen metot içinde dýþ kaynaklý Manager'ý new'leyebiliriz.
		// Adapter'larda new'lemekte sakýnca yok.
		
		JLoggerManager loggerManager = new JLoggerManager(); 
		loggerManager.log(message);
		
	}

}
