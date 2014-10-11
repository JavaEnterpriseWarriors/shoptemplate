package pl.javaenterprisewarriors.shoptemplate.tos;

public class CategoryTO extends StandardTO {
	private String name;
	
	public CategoryTO()
	{
		super();
	}
	
	public CategoryTO(CategoryTO categoryTO)
	{
		super(categoryTO);
		this.name = categoryTO.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = setInNotLocked(name);
	}
}
