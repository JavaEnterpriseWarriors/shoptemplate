package pl.javaenterprisewarriors.shoptemplate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import pl.javaenterprisewarriors.shoptemplate.annotations.NotForTO;

@Entity
@Table(name="STOREKEEPERS")
public class Storekeeper {
	@Id
	@GeneratedValue
	@Column(name="STOREKEEPER_ID")
	@NotForTO
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	public Storekeeper(){}
	
	public Storekeeper(String name, String lastName)
	{
		this.name = name;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
