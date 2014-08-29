package pl.javaenterprisewarriors.shoptemplate.dao;

import java.util.Collection;

import pl.javaenterprisewarriors.shoptemplate.domain.Product;

public interface ProductDAO {
	public void addProduct(Product product);
	
	public void updateProduct(Product product);
	
	public Product getProduct(int id);
	
	public Collection<Product> getAllProducts();
	
	public void deleteProduct(Product product);
}
