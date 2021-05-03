package ucuncuGunOdevi;

public class Instructor extends User {

	// fields
	private int superSecretKey; // burada da bir þey yazma amacý ile yazýldý.
	
	
	// constructor
	public Instructor(int id, String firstName, String lastName, String email, int password, String fullName, int superSecretKey) {
		super(id, firstName, lastName, email, password);
		// TODO Auto-generated constructor stub
		
		this.superSecretKey = superSecretKey;
	}

	
	// gets, sets
	public int getSuperSecretKey() {
		return superSecretKey;
	}
	public void setSuperSecretKey(int superSecretKey) {
		this.superSecretKey = superSecretKey;
	}

}
