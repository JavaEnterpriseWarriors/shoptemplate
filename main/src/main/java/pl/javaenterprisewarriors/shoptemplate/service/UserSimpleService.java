package pl.javaenterprisewarriors.shoptemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.javaenterprisewarriors.shoptemplate.dao.UserDAO;

@Transactional
public class UserSimpleService implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Transactional
	public boolean checkLogInData(String username, String password)
	{
		return userDAO.getUserByLoginData(username, password)!=null;
	}
	
	@Transactional
	public int getUserId(String username, String password)
	{
		return userDAO.getUserByLoginData(username, password).getId();
	}
}
