package pl.javaenterprisewarriors.shoptemplate.service.actors;

import org.springframework.beans.factory.annotation.Autowired;

import pl.javaenterprisewarriors.shoptemplate.domain.User;
import pl.javaenterprisewarriors.shoptemplate.service.UserComplexService;
import pl.javaenterprisewarriors.shoptemplate.shoppingcomponent.Basket;

public class SessionManager {
	private User user;
	private Basket basket;
	
	@Autowired
	private UserComplexService userService;
	
	public SessionManager(int userId)
	{
		this.user = userService.getUser(userId);
		this.basket = new Basket();
	}

	public Basket getBasket() {
		return basket;
	}

}
