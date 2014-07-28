package pl.spoko.jew88.onionshop;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {


	private UserService userService;
	
	@Inject
	public HomeController(UserService userService){
		this.userService = userService;
	}
	
	@RequestMapping({"/", "/home"})
	public String showHomePage(Map<String, Object> model){
		model.put("getall", userService.getAllUsers());
		return "home";
	}
	
}
