package pl.spoko.jew88.onionshop;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserRegistrationController {

	@Autowired
	private UserService userService;

	public UserRegistrationController() {
	}

	public UserRegistrationController(UserService userService) {
		this.setUserService(userService);
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String showRegistrationPage(Map<String, Object> model) {
		model.put("user", new User());
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String submitRegistration(User user, Map<String, Object> model) {
		getUserService().addUser(user);
		model.put("getall", getUserService().getAllUsers());
		return "home";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
