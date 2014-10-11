package pl.javaenterprisewarriors.shoptemplate.dao;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.javaenterprisewarriors.shoptemplate.domain.Product;
import pl.javaenterprisewarriors.shoptemplate.utils.HibernateUtils;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addProduct(Product product) {
		HibernateUtils.addElement(product);
	}

	public void updateProduct(Product product) {
		HibernateUtils.updateElement(product);
	}

	public Product getProduct(int id) {
		return HibernateUtils.getElement(Product.class, id);
	}

	public Collection<Product> getAllProducts() {
		return HibernateUtils.getAllElements(Product.class);
	}

	public void deleteProduct(Product product) {
		HibernateUtils.deleteElement(product);
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
