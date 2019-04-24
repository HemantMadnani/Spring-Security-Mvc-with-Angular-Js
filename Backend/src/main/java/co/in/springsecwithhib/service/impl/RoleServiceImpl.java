package co.in.springsecwithhib.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.in.springsecwithhib.dao.RoleDao;
import co.in.springsecwithhib.model.Role;
import co.in.springsecwithhib.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao userDao;

	@Override
	@Transactional
	public void addRole(final Role user) {

		userDao.addRole(user);
	}

	@Override
	@Transactional
	public void deleteRole(final Role user) {

		userDao.deleteRole(user);

	}

	@Override
	@Transactional
	public void updateRole(final Role user) {

		userDao.updateRole(user);
	}

	@Override
	@Transactional
	public List<Role> getAllRole() {

		return userDao.getAllRole();
	}

	@Override
	@Transactional
	public Role getSingleRole(final int id) {

		return userDao.getSingleRole(id);
	}

	@Override
	@Transactional
	public Role getRoleByRoleName(final String name) {

		return userDao.getRolebyRoleName(name);
	}

}
