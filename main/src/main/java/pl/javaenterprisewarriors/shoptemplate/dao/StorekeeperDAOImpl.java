package pl.javaenterprisewarriors.shoptemplate.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import pl.javaenterprisewarriors.shoptemplate.domain.Storekeeper;

@Repository
public class StorekeeperDAOImpl implements StorekeeperDAO {

	private SessionFactory sessionFactory;
	
	public void addStorekeepr(Storekeeper storekeeper) {
		sessionFactory.getCurrentSession().save(storekeeper);
	}

	public void updateStorekeeper(Storekeeper storekeeper) {
		sessionFactory.getCurrentSession().update(storekeeper);
	}

	public Storekeeper getStorekeeper(int id) {
		return (Storekeeper)sessionFactory.getCurrentSession().get(Storekeeper.class, id);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
