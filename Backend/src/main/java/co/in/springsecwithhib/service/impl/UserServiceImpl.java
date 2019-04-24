package co.in.springsecwithhib.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.in.springsecwithhib.dao.UserDao;
import co.in.springsecwithhib.model.User;
import co.in.springsecwithhib.service.UserService;
import co.in.springsecwithhib.util.PortalUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public void addUser(final User user) {

		user.setPassword(PortalUtils.bcryptPasswordEncoder(user.getPassword()));
		userDao.addUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(final User user) {

		userDao.deleteUser(user);

	}

	@Override
	@Transactional
	public void updateUser(final User user) {

		userDao.updateUser(user);
	}

	@Override
	@Transactional
	public List<User> getAllUser() {

		return userDao.getAllUser();
	}

	@Override
	@Transactional
	public User getSingleUser(final int id) {

		return userDao.getSingleUser(id);
	}

	@Override
	@Transactional
	public User getUserByEmail(final String email) {

		return userDao.getUserByEmail(email);
	}

}
