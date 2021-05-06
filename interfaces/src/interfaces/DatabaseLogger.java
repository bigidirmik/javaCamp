package interfaces;

//mirasta extends yazýyorduk, implemente söz konusu olunca ise implements yazýlýr.
//Add unimplemented method diyerek tamamlýyoruz
public class DatabaseLogger implements Logger {

	@Override
	public void log(String message) {
		
		System.out.println("Veritabanýna loglandý : " + message);
		
	}

}
