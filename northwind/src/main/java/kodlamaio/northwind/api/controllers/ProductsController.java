package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping("/findById")
	public DataResult<Product> findById(@RequestParam int productId){
		return this.productService.findById(productId);
	}

	@GetMapping("/getAll")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	
	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getAll(int pageNo, int pageSize){
		return this.productService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllAsc")
	public DataResult<List<Product>> getAllAsc(){
		return this.productService.getAllAsc();
	}
	
	@GetMapping("/getAllDesc")
	public DataResult<List<Product>> getAllDesc(){
		return this.productService.getAllDesc();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) { // @RequestBody verilen özellikleri Product class'ı içinde bulup map eder ve aşağıda ekleme yerine map edilmiş product'ı gönderir
		return this.productService.add(product);
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){ // yapılan isteiğin parametrelerini oku demek
		return this.productService.getByProductName(productName);
	}
	
	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);
	}
	
	@GetMapping("/getByProductNameOrCategoryId")
	public DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam String productName,@RequestParam int categoryId){
		return this.productService.getByProductNameOrCategoryId(productName, categoryId);
	}
	
	@GetMapping("/getByCategoryIdIn")
	public DataResult<List<Product>> getByCategoryIdIn(@RequestParam List<Integer> idsOfCategories){
		return this.productService.getByCategoryIdIn(idsOfCategories);
	}
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
	}
	
	@GetMapping("/getByProductNameStartsWith")
	public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName){
		return this.productService.getByProductNameStartsWith(productName);
	}
	
	@GetMapping("/getByProductNameEndsWith")
	public DataResult<List<Product>> getByProductNameEndsWith(@RequestParam String productName){
		return this.productService.getByProductNameEndsWith(productName);
	}
	
	@GetMapping("/getByNameAndCategoryId")
	public DataResult<List<Product>> getByNameAndCategoryId(@RequestParam String productName,@RequestParam int categoryId){
		return this.productService.getByNameAndCategoryId(productName, categoryId);
	}
	
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
	}
	
}