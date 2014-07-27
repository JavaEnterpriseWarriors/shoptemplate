package pl.spoko.jew88.onionshop;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public User getUser(int id) {
		return getUserDAO().getUser(id);
	}

	
	public void addUser(User user) {
		getUserDAO().saveUser(user);
	}

	
	public List<User> getAllUsers() {
		return getUserDAO().getAll();
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
