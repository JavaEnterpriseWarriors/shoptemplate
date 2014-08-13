package pl.javaenterprisewarriors.shoptemplate.dao;

import pl.javaenterprisewarriors.shoptemplate.domain.User;

public interface UserDAO {

	public void addUser(User user);

	public User getUserById(int id);

	public void updateUser(User user);

	public void deleteUser(User user);

	public User getUserByLoginData(String username, String password);

}
