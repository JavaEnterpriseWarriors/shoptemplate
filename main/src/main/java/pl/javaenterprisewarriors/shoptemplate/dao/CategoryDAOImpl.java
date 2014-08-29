package pl.javaenterprisewarriors.shoptemplate.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pl.javaenterprisewarriors.shoptemplate.domain.Category;

public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addCategory(Category category) {
		sessionFactory.getCurrentSession().save(category);
	}

	public Category getCategory(int id) {
		return (Category)sessionFactory.getCurrentSession().get(Category.class, id);
	}

	public void upadteCategory(Category category) {
		sessionFactory.getCurrentSession().update(category);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
