package pl.javaenterprisewarriors.shoptemplate.dao;

import java.util.Collection;

import pl.javaenterprisewarriors.shoptemplate.domain.Discount;
import pl.javaenterprisewarriors.shoptemplate.domain.Product;

public interface DiscountDAO {

	public Discount getProductDiscount(Product product);

	public Collection<Discount> getAllDiscounts();

}
