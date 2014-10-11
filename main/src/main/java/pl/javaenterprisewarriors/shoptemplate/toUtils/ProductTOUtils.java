package pl.javaenterprisewarriors.shoptemplate.toUtils;

import pl.javaenterprisewarriors.shoptemplate.domain.Product;
import pl.javaenterprisewarriors.shoptemplate.tos.ProductTO;

public interface ProductTOUtils {
	public ProductTO createProductTO(Product product);
	public ProductTO createProductTO();
	public void prepareProductTO();
	public void setProductName(String name);
	public void setProductPrice(Double price);
	public boolean areEquals(ProductTO productTO1, ProductTO productTO2);
	public ProductTO marge(ProductTO productTO1, ProductTO productTO2);
}
