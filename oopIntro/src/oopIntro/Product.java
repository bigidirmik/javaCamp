package oopIntro;

public class Product {
	
	//encapsulation
	
	private int id;
	private String name;
	private String detail;
	private double unitPrice;
	private double discount;
	
	// final ifadesi d��ardan eri�imi k�s�tlarken sadece constructor'da set edilebilmesini sa�lar
	// private (�zel) da sadece bu class'�n i�erisinde kullan�labilir demek
	
	public Product() {
		
	}

	
	public Product(int id, String name, String detail, double unitPrice, double discount) {
		super();
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.unitPrice = unitPrice;
		this.discount = discount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getUnitPriceAfterDiscount() {
		return unitPrice - (unitPrice * discount / 100) ;
	}
	
}
