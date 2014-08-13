package pl.javaenterprisewarriors.shoptemplate.shoppingcomponent;

import pl.javaenterprisewarriors.shoptemplate.domain.User;

public class Order {

	private Basket basket;
	private User user;

	public Order(Basket basket, User user) {
		this.setBasket(basket);
		this.setUser(user);
	}

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
