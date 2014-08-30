package pl.javaenterprisewarriors.shoptemplate.service;

import org.springframework.beans.factory.annotation.Autowired;

import pl.javaenterprisewarriors.shoptemplate.dao.ProductDAO;
import pl.javaenterprisewarriors.shoptemplate.domain.Product;

public class ProductService {
	@Autowired
	private ProductDAO productDAO;
	
	public Product getProduct(int id)
	{
		return productDAO.getProduct(id);
	}
	
	public void addProduct(Product product)
	{
		productDAO.addProduct(product);
	}
	
	public void updateProduct(Product product)
	{
		productDAO.updateProduct(product);
	}
	
	public void removeProduct(Product product)
	{
		productDAO.deleteProduct(product);
	}

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
}
