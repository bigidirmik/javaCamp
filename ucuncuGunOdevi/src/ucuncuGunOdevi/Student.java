package ucuncuGunOdevi;

public class Student extends User {

	// fields
	private int progress;
	
	
	// constructor
	public Student(int id, String firstName, String lastName, String email, int password, String fullName,int progress) {
		super(id, firstName, lastName, email, password);
		// TODO Auto-generated constructor stub
		
		this.progress = progress;
	}

	
	// gets, sets
	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

}
