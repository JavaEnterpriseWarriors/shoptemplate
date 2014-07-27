package pl.spoko.jew88.onionshop;

import java.util.List;

public interface UserDAO {

	public User getUser(int id);
	public void saveUser(User user);
	public List<User> getAll();
	
}
