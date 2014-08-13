package pl.javaenterprisewarriors.shoptemplate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.javaenterprisewarriors.shoptemplate.domain.Discount;
import pl.javaenterprisewarriors.shoptemplate.domain.Product;

@Repository
public class DiscountDAOImpl implements DiscountDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Discount getProductDiscount(Product product) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Discount.class);
		criteria.add(Restrictions.like("product", product));
		List<?> list = criteria.list();
		if (list != null && list.get(0) != null)
			return (Discount) list.get(0);
		return null;
	}

	public List<Discount> getAllDiscounts() {
		return sessionFactory.getCurrentSession()
				.createCriteria(Discount.class).list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
