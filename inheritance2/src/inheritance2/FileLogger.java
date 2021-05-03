package inheritance2;

public class FileLogger extends Logger {

	@Override // java kendisi override eder ancak kod okunurluðu için yazarýz
	public void log() { // base class'ta da log var - buna Method Override etmek denir - üzerine yazma
		System.out.println("Dosyaya loglandý");
	}

}
