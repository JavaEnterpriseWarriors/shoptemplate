package pl.javaenterprisewarriors.shoptemplate.dao;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.javaenterprisewarriors.shoptemplate.domain.Product;
import pl.javaenterprisewarriors.shoptemplate.domain.Storage;

@Repository
public class StorageDAOImpl implements StorageDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addStorage(Storage storage) {
		sessionFactory.getCurrentSession().save(storage);
	}

	public Storage getStorage(int id) {
		return (Storage)sessionFactory.getCurrentSession().get(Storage.class, id);
	}

	//Hibernte make sure that List<Product> is passed
	@SuppressWarnings("unchecked")
	public Collection<Product> getAllProductInStorage(int id) {
		Collection<Integer> idCollection = sessionFactory.getCurrentSession().createQuery("Select PRODUCT_ID From STORAGE Where STORAGE_ID="+id+";").list();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
		criteria.add(Restrictions.in("id", idCollection));
		return criteria.list();
		//TODO napewno da siê tolepiej rozwi¹zaæ
		//return sessionFactory.getCurrentSession().createQuery("Select * From PRODUCT where PRODUCT_ID in (Select PRODUCT_ID From STORAGE Where STORAGE_ID="+id+")").list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void updateStorage(Storage storage) {
		sessionFactory.getCurrentSession().update(storage);
	}

}
