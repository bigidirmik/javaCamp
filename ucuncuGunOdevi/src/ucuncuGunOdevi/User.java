package ucuncuGunOdevi;

public class User {
	
	// fields
	private int id;
	private String email;
	private int password;
	
	
	//constructor
	public User(int id, String email, int password) {
		
		this.id = id;
		this.email = email;
		this.password = password;
	}


	// gets, sets
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}

}
