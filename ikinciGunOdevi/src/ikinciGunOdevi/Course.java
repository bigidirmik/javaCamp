package ikinciGunOdevi;

public class Course {
	
	int id;
	String imagePath;
	String name;
	int progress;
	String instructor;
	
	public Course() {
		System.out.println("I worked!");
	}
	
	public Course(int id, String imagePath, String name, int progress, String instructor) {
		
		this();
		this.id = id;
		this.imagePath = imagePath;
		this.name = name;
		this.progress = progress;
		this.instructor = instructor;
		
	}

}
