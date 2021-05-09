package nLayeredDemo;

import nLayeredDemo.business.abstracts.ProductService;
import nLayeredDemo.business.concretes.ProductManager;
import nLayeredDemo.core.JLoggerManagerAdapter;
import nLayeredDemo.dataAccess.concretes.AbcProductDao;
import nLayeredDemo.entities.concretes.Product;

public class Main {

	public static void main(String[] args) {
		
		// Entity'ler hari� new'liyor isek s�k�nt�l� bir durum demektir.
		// ToDo: Spring IoC ile ��z�lecek.
		ProductService productService = new ProductManager(new AbcProductDao(), new JLoggerManagerAdapter());
		// As�l JLoggerManager package olarak var.
		// JLoggerManagerAdapter ise core i�inde : D�� Servisleri Adapte Etmek ��in Bu Class'a Gir Kullan�m�na Bak.
		
		Product product = new Product(1, 2, "Elma", 12, 50);
		productService.add(product);

	}

}
