package ucuncuGunOdevi;

public class Student extends User {

	// fields
	private int userId;
	private String firstName;
	private String lastName;
	private String fullName;
	private int progress;
	
	
	// constructor
	public Student(int id, int userId, String firstName, String lastName, String email, int password, int progress) {
		super(id, email, password);
		
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.progress = progress;
	}
	
	
	// gets, sets
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		fullName = firstName + " " + lastName;
		return fullName;
	}

	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}

}
