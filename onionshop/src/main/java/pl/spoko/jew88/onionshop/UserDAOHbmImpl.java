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

	public User getUser(int id) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
		return user;
	}

	public void saveUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	public List<User> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
