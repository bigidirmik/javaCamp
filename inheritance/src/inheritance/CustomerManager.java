package inheritance;

public class CustomerManager {
	
	
	public void Add(Customer customer) { 
		System.out.println(customer.customerNumber + " eklendi.");
	}
	
	
	
	//bulk insert - çoklu ekleme
	
	public void AddMultiple(Customer[] customers) {
		for(Customer customer : customers) {
			Add(customer); // yukarýdaki Add metodu
		}
	}
	
	
	
	// extends ettiðimiz için iki müþteri tipi için ayrý ayrý Add yazmamýza gerek kalmadý
	// artýk solid O harfine uygun þekilde (open closed principle) hiçbir kodu deðiþtirmeden sadece kod ekleyerek yeni müþteri
	// tipi de ekleyebiliriz. (union customer - sendikal müþteriyi böyle ekledik ve solid prensibe uyarak hiçbir þeyi deðiþtirmedik)
	
}
