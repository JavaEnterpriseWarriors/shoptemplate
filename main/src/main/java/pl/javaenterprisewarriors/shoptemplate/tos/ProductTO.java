package pl.javaenterprisewarriors.shoptemplate.tos;

public class ProductTO extends StandardTO {
	private String name;
	private Double price;
	
	public ProductTO()
	{
		super();
	}
	
	public ProductTO(ProductTO to)
	{
		super(to);
		this.name = to.name;
		this.price = to.price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		//this.name = setInNotLocked(name);
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = setInNotLocked(price);
	}
	
}
