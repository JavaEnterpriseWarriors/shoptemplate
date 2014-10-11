package pl.javaenterprisewarriors.shoptemplate.tos;

public class StorekeeperTO extends StandardTO {
	private String name;
	private String lastName;
	
	public StorekeeperTO()
	{
		super();
	}
	
	public StorekeeperTO(StorekeeperTO storekeeperTO)
	{
		super(storekeeperTO);
		this.name = storekeeperTO.name;
		this.lastName = storekeeperTO.lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = setInNotLocked(lastName);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = setInNotLocked(name);
	}
}
