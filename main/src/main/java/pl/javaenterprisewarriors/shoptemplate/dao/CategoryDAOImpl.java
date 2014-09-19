package pl.javaenterprisewarriors.shoptemplate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.javaenterprisewarriors.shoptemplate.domain.Category;

@Repository
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
		//sessionFactory.getCurrentSession().flush();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void deleteCategory(Category category) {
		sessionFactory.getCurrentSession().clear();
		sessionFactory.getCurrentSession().delete(category);
	}

	//Safe cast hibernate make shure that list contains only Category objects
	@SuppressWarnings("unchecked")
	public List<Category> getAllSubCategories(int id) {
		Category category = (Category)sessionFactory.getCurrentSession().get(Category.class,id);
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Category.class);
		criteria.add(Restrictions.like("parentCategory", category));
		
		return criteria.list();
	}

	//Safe cast hibernate make shure that list contains only Category objects
	@SuppressWarnings("unchecked")
	public List<Category> getAllCategories() {
		return sessionFactory.getCurrentSession().createCriteria(Category.class).list();
	}

}
