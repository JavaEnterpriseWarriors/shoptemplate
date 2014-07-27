package pl.spoko.jew88.onionshop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ShopMain {
	
	private static UserService userService; 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		userService.addUser(new User("Janusz", "Cebula", "janusz.cebula@spoko.pl"));
		userService.addUser(new User("Andrzej", "Kozak", "andrzej.kozak@spoko.pl"));
		
		List<User> uzytkownicy = userService.getAllUsers();
		for (User u : uzytkownicy){
			System.out.println(u.getName() + " " + u.getSurname() + " " + u.getEmail());
		}
		
	}

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
