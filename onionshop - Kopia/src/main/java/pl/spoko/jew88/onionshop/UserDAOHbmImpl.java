package pl.spoko.jew88.onionshop;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOHbmImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User getUser(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = (User) sessionFactory.getCurrentSession().get(User.class,
				id);
		session.getTransaction().commit();
		return user;
	}

	@Override
	public void saveUser(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}

	@Override
	public List<User> getAll() {
		Session session = sessionFactory.openSession();
		return session.createCriteria(User.class).list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
