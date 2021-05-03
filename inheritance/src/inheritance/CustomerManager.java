package inheritance;

public class CustomerManager {
	
	
	public void Add(Customer customer) { 
		System.out.println(customer.customerNumber + " eklendi.");
	}
	
	
	
	//bulk insert - �oklu ekleme
	
	public void AddMultiple(Customer[] customers) {
		for(Customer customer : customers) {
			Add(customer); // yukar�daki Add metodu
		}
	}
	
	
	
	// extends etti�imiz i�in iki m��teri tipi i�in ayr� ayr� Add yazmam�za gerek kalmad�
	// art�k solid O harfine uygun �ekilde (open closed principle) hi�bir kodu de�i�tirmeden sadece kod ekleyerek yeni m��teri
	// tipi de ekleyebiliriz. (union customer - sendikal m��teriyi b�yle ekledik ve solid prensibe uyarak hi�bir �eyi de�i�tirmedik)
	
}
