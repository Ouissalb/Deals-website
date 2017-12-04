package ma.ac.ensa.model;

public class Utilisateur {
	
	private int id;
	private String username;
	private String password;
	private String email;
	private String role;
	
	public Utilisateur() {}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Utilisateur(String username, String password, String email, String role)
	{
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
