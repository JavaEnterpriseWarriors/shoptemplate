package pl.javaenterprisewarriors.shoptemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pl.javaenterprisewarriors.shoptemplate.dao.UserDAO;
import pl.javaenterprisewarriors.shoptemplate.domain.User;

@Transactional
public class UserComplexService implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Transactional
	public User getUser(int id) {
		return userDAO.getUserById(id);
	}
}
