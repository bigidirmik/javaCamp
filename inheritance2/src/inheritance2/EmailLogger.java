package inheritance2;

public class EmailLogger extends Logger {

	@Override // java kendisi override eder ancak kod okunurlu�u i�in yazar�z
	public void log() { // base class'ta da log var - buna Method Override etmek denir - �zerine yazma
		System.out.println("Email log g�nderildi");
	}

}
