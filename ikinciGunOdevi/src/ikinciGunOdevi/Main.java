package ikinciGunOdevi;

public class Main {

	public static void main(String[] args) {

		// Kurslar

		Course course1 = new Course(1, "image/programlamayagiris.jpg", "Programlamaya Giri� ��in Temel Kurs ", 100,
				"Engin Demiro�");

		Course course2 = new Course(2, "image/csahrp-angular.jpg",
				"Yaz�l�m Geli�tirici Yeti�tirme Kamp� (C# + ANGULAR) ", 98, "Engin Demiro�");

		Course course3 = new Course(3, "image/java-react.jpg", "Yaz�l�m Geli�tirici Yeti�tirme Kamp� (JAVA + REACT) ",
				32, "Engin Demiro�");

		// Kurs Dizisi

		Course[] courses = { course1, course2, course3 };

		// D�ng�

		System.out.println("-------------------Kurslar--------------------");

		for (Course course : courses) {
			System.out.println("--------------------" + course.id + "--------------------");
			System.out.println("Kurs : " + course.name + " " + course.instructor + " - " + course.imagePath);
		}

		// Manager

		CourseManager courseManager = new CourseManager();

		System.out.println("-----------------------------" + course1.id + "------------------------------------");
		courseManager.add(course1);
		courseManager.addImage(course1);
		courseManager.update(course1);
		courseManager.updateImage(course1);
		courseManager.delete(course1);
		courseManager.deleteImage(course1);
		courseManager.progress(course1);
		
		System.out.println("-----------------------------" + course2.id + "------------------------------------");
		courseManager.add(course2);
		courseManager.addImage(course2);
		courseManager.update(course2);
		courseManager.updateImage(course2);
		courseManager.delete(course2);
		courseManager.deleteImage(course2);
		courseManager.progress(course2);
		
		System.out.println("-----------------------------" + course3.id + "------------------------------------");
		courseManager.add(course3);
		courseManager.addImage(course3);
		courseManager.update(course3);
		courseManager.updateImage(course3);
		courseManager.delete(course3);
		courseManager.deleteImage(course3);
		courseManager.progress(course3);
		
		System.out.println("-----------------------------------------------------------------------------------");
		
		courseManager.getall(courses);

	}

}
