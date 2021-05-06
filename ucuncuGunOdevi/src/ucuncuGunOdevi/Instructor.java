package ucuncuGunOdevi;

public class Instructor extends User {

	// fields
	private int userId;
	private String firstName;
	private String lastName;
	private String fullName;
	private String superSecretKey; // burada da bir þey yazma amacý ile yazýldý.
	
	
	// constructor
	public Instructor(int id, int userId, String firstName, String lastName, String email, int password, String superSecretKey) {
		super(id, email, password);
		
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.superSecretKey = superSecretKey;
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

	public String getSuperSecretKey() {
		return superSecretKey;
	}
	public void setSuperSecretKey(String superSecretKey) {
		this.superSecretKey = superSecretKey;
	}

}
