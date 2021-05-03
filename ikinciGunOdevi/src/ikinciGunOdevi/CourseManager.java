package ikinciGunOdevi;

public class CourseManager {
	

	public void add(Course course) {
		System.out.println(course.name + " eklendi.");
	}
	public void addImage(Course course) {
		System.out.println(course.imagePath + " g�rsel eklendi.");
	}
	

	public void update(Course course) {
		System.out.println(course.name + " g�ncellendi.");
	}
	public void updateImage(Course course) {
		System.out.println(course.imagePath + " g�rsel g�ncellendi.");
	}
	

	public void delete(Course course) {
		System.out.println(course.name + " silindi.");
	}
	public void deleteImage(Course course) {
		System.out.println(course.imagePath + " g�rsel silindi.");
	}
	
	
	public void progress(Course course) {
		System.out.println(course.name + course.progress + "% tamamland�.");
	}

	
	public void getall(Course[] courses) {
		for(Course course : courses) {
			System.out.println(course.name);
		}
	}
	
}
