package nLayeredDemo;

import nLayeredDemo.business.abstracts.ProductService;
import nLayeredDemo.business.concretes.ProductManager;
import nLayeredDemo.core.JLoggerManagerAdapter;
import nLayeredDemo.dataAccess.concretes.AbcProductDao;
import nLayeredDemo.entities.concretes.Product;

public class Main {

	public static void main(String[] args) {
		
		// Entity'ler hariç new'liyor isek sýkýntýlý bir durum demektir.
		// ToDo: Spring IoC ile çözülecek.
		ProductService productService = new ProductManager(new AbcProductDao(), new JLoggerManagerAdapter());
		// Asýl JLoggerManager package olarak var.
		// JLoggerManagerAdapter ise core içinde : Dýþ Servisleri Adapte Etmek Ýçin Bu Class'a Gir Kullanýmýna Bak.
		
		Product product = new Product(1, 2, "Elma", 12, 50);
		productService.add(product);

	}

}
