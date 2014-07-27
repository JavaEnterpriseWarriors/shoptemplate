package pl.spoko.jew88.onionshop;

import java.util.List;

public interface UserService {

		public User getUser(int id);
		public void addUser(User user);
		public List<User> getAllUsers();
		
}
