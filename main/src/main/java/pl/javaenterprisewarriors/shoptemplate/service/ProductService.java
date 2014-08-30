package pl.javaenterprisewarriors.shoptemplate.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.javaenterprisewarriors.shoptemplate.dao.ProductDAO;
import pl.javaenterprisewarriors.shoptemplate.domain.Product;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductDAO productDAO;

	@Transactional
	public Product getProduct(int id) {
		return productDAO.getProduct(id);
	}

	@Transactional
	public void addProduct(Product product) {
		productDAO.addProduct(product);
	}

	@Transactional
	public void updateProduct(Product product) {
		productDAO.updateProduct(product);
	}

	@Transactional
	public void removeProduct(Product product) {
		productDAO.deleteProduct(product);
	}

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
}
