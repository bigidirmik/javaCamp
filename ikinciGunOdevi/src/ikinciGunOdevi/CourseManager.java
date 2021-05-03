package ikinciGunOdevi;

public class CourseManager {
	

	public void add(Course course) {
		System.out.println(course.name + " eklendi.");
	}
	public void addImage(Course course) {
		System.out.println(course.imagePath + " görsel eklendi.");
	}
	

	public void update(Course course) {
		System.out.println(course.name + " güncellendi.");
	}
	public void updateImage(Course course) {
		System.out.println(course.imagePath + " görsel güncellendi.");
	}
	

	public void delete(Course course) {
		System.out.println(course.name + " silindi.");
	}
	public void deleteImage(Course course) {
		System.out.println(course.imagePath + " görsel silindi.");
	}
	
	
	public void progress(Course course) {
		System.out.println(course.name + course.progress + "% tamamlandý.");
	}

	
	public void getall(Course[] courses) {
		for(Course course : courses) {
			System.out.println(course.name);
		}
	}
	
}
