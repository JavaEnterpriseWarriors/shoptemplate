package pl.javaenterprisewarriors.shoptemplate.factory;

import pl.javaenterprisewarriors.shoptemplate.domain.User;
import pl.javaenterprisewarriors.shoptemplate.shoppingcomponent.Basket;
import pl.javaenterprisewarriors.shoptemplate.shoppingcomponent.Order;

public class OrderFactory {

	public static Order createOrder(Basket basket, User user) {
		if (basket != null && user != null) {
			return new Order(basket, user);
		} else
			throw new IllegalArgumentException(
					"Incorrect argument value - NULL");
	}
}
