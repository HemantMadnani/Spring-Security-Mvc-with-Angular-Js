package co.in.springsecwithhib.service;

import java.util.List;

import co.in.springsecwithhib.model.User;

public interface UserService {

	public void addUser(User user);

	public void deleteUser(User user);

	public void updateUser(User user);

	public List<User> getAllUser();

	public User getSingleUser(int id);

	public User getUserByEmail(String email);
}
