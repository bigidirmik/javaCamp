package intro;

public class Main {

	public static void main(String[] args) {
		
		String internetSubeButonu = "�nternet �ubesi";
		
		System.out.println(internetSubeButonu);
		
		double dolarDun = 8.20;
		double dolarBugun = 8.20;
		int vade = 36;
		boolean dustuMu = false;
		
		if(dolarBugun<dolarDun) {
			System.out.println("Dolar d��t� resmi");
		}else if(dolarBugun>dolarDun) {
			System.out.println("Dolar y�kseldi resmi");
		}else {
			System.out.println("Dolar e�ittir resmi");
		}
		
		String [] krediler = {
				"H�zl� kredi",
				"Mutlu emekli kredisi",
				"Konut kredisi",
				"�ift�i kredisi",
				"MSB kredisi",
				"MEB kredisi",
				"K�lt�r Bakanl��� kredisi"
		};
		
		//foreach
		for(String kredi : krediler) {
			System.out.println(kredi);
		}
		
		//for
		for(int i = 0; i<krediler.length;i++) {
			System.out.println(krediler[i]);
		}
		
		
		// Referans ve De�er Tipler
		
		//De�er
		int sayi1 = 10;
		int sayi2 = 20;
		sayi1 = sayi2;
		sayi2 = 100;
		
		System.out.println(sayi1); // 20
		
		//Referans
		int[] sayilar1 = {1,2,3,4,5};
		int[] sayilar2 = {10,20,30,40,50};
		sayilar1=sayilar2;
		sayilar2[0]=100;
		
		System.out.println(sayilar1[0]); // 100
		
		//String de�er tip gibi �al���r
		String sehir1 = "Ankara";
		String sehir2 = "�stanbul";
		sehir1 = sehir2;
		sehir2 = "�zmir";
		
		System.out.println(sehir1); // �stanbul
		
	}

}
