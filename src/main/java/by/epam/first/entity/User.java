 package by.epam.first.entity;

/**
 * Created by User on 18.08.2016.
 */
public class User extends Entity {
	public enum Role{
		ROLE_USER, ROLE_ADMIN
	}
	
	private String username;
	private String password;
	private Role role = Role.ROLE_USER;
	
	public User(){}

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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
