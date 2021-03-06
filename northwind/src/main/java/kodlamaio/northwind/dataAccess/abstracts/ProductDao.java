package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer>{

	// Bu isimlendirme kurallarına uyulan metotlar jpa ile otomatik olarak veri tabanı sorgusu yaparlar
	
	Product findById(int productId);
	
	Product getByProductName(String productName);
	// select * from products where product_name = abc
	
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	// select * from products where product_name = abc AND category_id = x
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	// select * from products where product_name = abc OR category_id = x
	
	List<Product> getByCategory_CategoryIdIn(List<Integer> idsOfCategories); // list parametre şart değil, dönülebilir her yapı olabilir.
	// select * from products where category_id in(x,y,z,w)
	
	List<Product> getByProductNameContains(String productName); // içeren
	
	List<Product> getByProductNameStartsWith(String productName); // ile başlayan
	
	List<Product> getByProductNameEndsWith(String productName); // ile biten
	
	
	// JPQL
	
	// querry'i yazarken veri tabanını unut! buradaki hangi entity demek
	@Query("From Product where productName = :productName and category.categoryId = :categoryId")
	List<Product> getByNameAndCategory_CategoryId(String productName, int categoryId);
	
	
	// DTO
	
	@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName)"
			+ "From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
	// select p.productId, p.productName, c.categoryName
	// from Category c inner join Product p
	// on c.categoryId = p.categoryId;
	
}
