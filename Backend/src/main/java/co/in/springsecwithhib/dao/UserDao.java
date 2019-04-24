package co.in.springsecwithhib.dao;

import java.util.List;

import co.in.springsecwithhib.model.User;

public interface UserDao {

	public void addUser(User user);

	public void deleteUser(User user);

	public void updateUser(User user);

	public List<User> getAllUser();

	public User getSingleUser(int id);

	public User getUserByEmail(String email);

}
