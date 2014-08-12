package pl.javaenterprisewarriors.shoptemplate.domain;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String password;
	private String email;
	private String country;
	private String zipCode;
	private String street;
	private int phoneNumber;

	public User() {
	}

	public User(String username, String password, String email, String country,
			String zipCode, String street, int phoneNumber) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.country = country;
		this.zipCode = zipCode;
		this.street = street;
		this.phoneNumber = phoneNumber;
	}
}
