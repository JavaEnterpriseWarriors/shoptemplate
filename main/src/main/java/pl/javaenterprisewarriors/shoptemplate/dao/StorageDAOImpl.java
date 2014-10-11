package pl.javaenterprisewarriors.shoptemplate.dao;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Projection;
import org.springframework.stereotype.Repository;

import pl.javaenterprisewarriors.shoptemplate.domain.Product;
import pl.javaenterprisewarriors.shoptemplate.domain.Storage;
import pl.javaenterprisewarriors.shoptemplate.utils.HibernateUtils;

@Repository
public class StorageDAOImpl implements StorageDAO {

	// @Autowired
	// private SessionFactory sessionFactory;

	public void addStorage(Storage storage) {
		HibernateUtils.addElement(storage);
		// sessionFactory.getCurrentSession().save(storage);
	}

	public Storage getStorage(int id) {
		return HibernateUtils.getElement(Storage.class, id);
		// return (Storage)sessionFactory.getCurrentSession().get(Storage.class,
		// id);
	}

	// TODO do poprawki NIE DZIA£A
	// Hibernte make sure that List<Product> is passed
	@SuppressWarnings("unchecked")
	public Collection<Product> getAllProductInStorage(int id) {
		// Collection<Integer> idCollection =
		// HibernateUtils.getCurrentSession().createQuery("Select products From Storage Where Storage.id="+id).list();
		// Criteria criteria =
		// HibernateUtils.getCurrentSession().createCriteria(Product.class);
		// criteria.add(Restrictions.in("id", idCollection));

		Criteria criteria = HibernateUtils.getCurrentSession()
				.createCriteria(Storage.class)
				.setProjection(Projections.projectionList()
					      .add(Projections.property("products"), "products"))
				.add(Restrictions.like("id", id))
				.setResultTransformer(Transformers.aliasToBean(Product.class));
		return (Collection<Product>) criteria.list().get(0);
	}

	// public SessionFactory getSessionFactory() {
	// return sessionFactory;
	// }
	//
	// public void setSessionFactory(SessionFactory sessionFactory) {
	// this.sessionFactory = sessionFactory;
	// }

	public void updateStorage(Storage storage) {
		HibernateUtils.updateElement(storage);
		// sessionFactory.getCurrentSession().update(storage);
	}

	public void delateStorage(int id) {
		HibernateUtils.deleteElement(Storage.class, id);
		// Storage storage = getStorage(id);
		// sessionFactory.getCurrentSession().delete(storage);
	}

	public int getStorageIdByName(String name) {
		Criteria criteria = HibernateUtils.getCurrentSession().createCriteria(
				Storage.class);
		criteria.add(Restrictions.ilike("name", name));
		return ((Storage) criteria.list().get(0)).getId();
	}

	//TODO NIEDZIA£A najpierw potrzebne jest zapytanie na zwrucenie wszystkich produktów
	public Product getProductInStorage(int storageId, int productId) {
		Criteria criteria = HibernateUtils.getCurrentSession().createCriteria(Product.class);
		return null;
	}

}
