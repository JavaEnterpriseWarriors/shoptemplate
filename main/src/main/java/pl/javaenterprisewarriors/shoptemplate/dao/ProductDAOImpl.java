package pl.javaenterprisewarriors.shoptemplate.dao;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.javaenterprisewarriors.shoptemplate.domain.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);
	}

	public void updateProduct(Product product) {
		sessionFactory.getCurrentSession().update(product);
	}

	public Product getProduct(int id) {
		return (Product)sessionFactory.getCurrentSession().get(Product.class, id);
	}

	//Hibernte make sure that List<Product> is passed
	@SuppressWarnings("unchecked")
	public Collection<Product> getAllProducts() {
		return sessionFactory.getCurrentSession().createCriteria(Product.class).list();
	}

	public void deleteProduct(Product product) {
		sessionFactory.getCurrentSession().delete(product);
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
