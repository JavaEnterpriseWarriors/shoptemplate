package pl.javaenterprisewarriors.shoptemplate.service.actors;

import org.springframework.beans.factory.annotation.Autowired;

import pl.javaenterprisewarriors.shoptemplate.service.UserSimpleService;

public class LogInManager {
	@Autowired
	private UserSimpleService userService;
	
	public void checkLogingData(String userName, String password)
	{
		if(userService.checkLogInData(userName, password))
		{
			logIn(userService.getUserId(userName, password));
		}
	}
	
	private void logIn(int userId)
	{
		//TODO utworzyæ instancje Shopping Provider
	}
}
