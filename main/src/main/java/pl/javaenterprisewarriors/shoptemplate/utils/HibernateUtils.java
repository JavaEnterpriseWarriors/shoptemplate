package pl.javaenterprisewarriors.shoptemplate.utils;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateUtils {
	
	private static SessionFactory sessionFactory;
	
	public static Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	public static void addElement(Object element)
	{
		getCurrentSession().save(element);
	}
	
	//hibernate will return object of proper clas
	@SuppressWarnings("unchecked")
	public static <T> T getElement(Class<T> clazz, int id)
	{
		return (T)getCurrentSession().get(clazz, id);
	}
	
	public static <T> void deleteElement(Class<T> clazz, int id)
	{
		T element = getElement(clazz, id);
		getCurrentSession().delete(element);
	}
	
	public static void deleteElement(Object element)
	{
		//getCurrentSession().clear();
		getCurrentSession().delete(element);
	}
	
	public static void updateElement(Object element)
	{
		getCurrentSession().clear();
		getCurrentSession().update(element);
	}

	//hiberante returns collection of proper types
	@SuppressWarnings("unchecked")
	public static <T> Collection<T> getAllElements(Class<T> clazz)
	{
		return getCurrentSession().createCriteria(clazz).list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		HibernateUtils.sessionFactory = sessionFactory;
	}
}
