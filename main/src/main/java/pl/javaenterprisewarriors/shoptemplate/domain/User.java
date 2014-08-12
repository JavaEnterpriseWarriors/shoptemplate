package pl.javaenterprisewarriors.shoptemplate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	@Column(name = "country")
	private String country;
	@Column(name = "zip_code")
	private String zipCode;
	@Column(name = "street")
	private String street;
	@Column(name = "phone_number")
	private int phoneNumber;

	public User() {
	}

	public User(String username, String password, String email, String country,
			String zipCode, String street, int phoneNumber) {
		this.setUsername(username);
		this.setPassword(password);
		this.setEmail(email);
		this.setCountry(country);
		this.setZipCode(zipCode);
		this.setStreet(street);
		this.setPhoneNumber(phoneNumber);
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
