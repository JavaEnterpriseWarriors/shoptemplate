package pl.javaenterprisewarriors.utils;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pl.javaenterprisewarriors.shoptemplate.domain.Category;

public class HibernateUtils {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	public void addElement(Object element)
	{
		getCurrentSession().save(element);
	}
	
	//hibernate will return object of proper clas
	@SuppressWarnings("unchecked")
	public <T> T getElement(T clazz, int id)
	{
		return (T)getCurrentSession().get(clazz.getClass(), id);
	}
	
	public <T> void deleteElement(T clazz, int id)
	{
		T element = getElement(clazz, id);
		getCurrentSession().delete(element);
	}
	
	public void deleteElement(Object element)
	{
		getCurrentSession().delete(element);
	}
	
	//hiberante returns collection of proper types
	@SuppressWarnings("unchecked")
	public <T> Collection<T> getAllElements(T clazz)
	{
		return getCurrentSession().createCriteria(clazz.getClass()).list();
	}
}
