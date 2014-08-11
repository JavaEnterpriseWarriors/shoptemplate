package pl.spoko.jew88.onionshop;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	public HomeController(){}

	public HomeController(UserService userService){
		this.setUserService(userService);
	}
	
	@RequestMapping(value="/")
	public String showHomePage(Map<String, Object> model){
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
