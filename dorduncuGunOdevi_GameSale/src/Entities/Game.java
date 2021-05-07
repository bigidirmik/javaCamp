package Entities;

import Abstract.Entity;

public class Game implements Entity{
	
	private int id;
	private String genre;
	private String developer;
	private String publisher;
	private String name;
	private int releaseDate;
	private double price;
	
	
	public Game
	(int id, String genre, String developer, String publisher, String name, int releaseDate, double price)
	{
		super();
		this.id = id;
		this.genre = genre;
		this.developer = developer;
		this.publisher = publisher;
		this.name = name;
		this.releaseDate = releaseDate;
		this.price = price;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDeveloper() {
		return developer;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
