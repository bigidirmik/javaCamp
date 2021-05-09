package nLayeredDemo.core;

import nLayeredDemo.jLogger.JLoggerManager;

public class JLoggerManagerAdapter implements LoggerService {

	@Override
	public void logToSystem(String message) {
		
		// Core katman�nda kendi Service'imizi ve Adapter class'�n� yaz�p yukar�daki gibi implements yapt�k.
		// Ard�ndan overrride edilen metot i�inde d�� kaynakl� Manager'� new'leyebiliriz.
		// Adapter'larda new'lemekte sak�nca yok.
		
		JLoggerManager loggerManager = new JLoggerManager(); 
		loggerManager.log(message);
		
	}

}
