package pl.javaenterprisewarriors.shoptemplate.tos;

public class StorageTO extends StandardTO{
	private String name;
	
	public StorageTO()
	{
		super();
	}
	
	public StorageTO(StorageTO to)
	{
		super(to);
		this.name = to.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = setInNotLocked(name);
	}
	
}
