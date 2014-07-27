package pl.spoko.jew88.onionshop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Transactional
	public User getUser(int id) {
		return getUserDAO().getUser(id);
	}

	@Transactional
	public void addUser(User user) {
		getUserDAO().saveUser(user);
	}

	@Transactional
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
