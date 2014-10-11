package pl.javaenterprisewarriors.shoptemplate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.javaenterprisewarriors.shoptemplate.domain.Category;
import pl.javaenterprisewarriors.shoptemplate.utils.HibernateUtils;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	public void addCategory(Category category) {
		HibernateUtils.addElement(category);
	}

	public Category getCategory(int id) {
		return HibernateUtils.getElement(Category.class, id);
	}

	public void upadteCategory(Category category) {
		HibernateUtils.updateElement(category);
	}

	public void deleteCategory(Category category) {
		HibernateUtils.deleteElement(category);
	}

	//Safe cast hibernate make shure that list contains only Category objects
	@SuppressWarnings("unchecked")
	public List<Category> getAllSubCategories(int id) {
		Category category = (Category)HibernateUtils.getCurrentSession().get(Category.class,id);
		Criteria criteria = HibernateUtils.getCurrentSession().createCriteria(Category.class);
		criteria.add(Restrictions.like("parentCategory", category));
		
		return criteria.list();
	}

	public List<Category> getAllCategories() {
		return (List<Category>) HibernateUtils.getAllElements(Category.class);
	}

}
