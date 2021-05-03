package oopIntro;

public class Main {

	public static void main(String[] args) {
		
		// percistency : veriyi kalýcý bir yerde saklamaktýr.
		
		// örnek (referans), instance oluþturma, new'leme (create instance)
		
		
		Product product1 = new Product(1, "Lenovo V14", "16 GB RAM", 15000, 10);
		
		System.out.println(product1.getName());
		
		
		
		Product product2 = new Product();
		product2.setId(1);
		product2.setName("Lenovo V15");
		product2.setDetail("16 GB RAM");
		product2.setUnitPrice(16000);
		product2.setDiscount(10);
		
		System.out.println(product2.getUnitPriceAfterDiscount());
		
		
		
		Category category1 = new Category();
		category1.setId(1);
		category1.setName("Ýçecek");
		
		System.out.println(category1.getName());
		
		
		
		Category category2 = new Category();
		category2.setId(2);
		category2.setName("Yiyecek");
		
		System.out.println(category2.getName());
		
	}

}
