package co.in.springsecwithhib.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.in.springsecwithhib.dao.AuthorityDao;
import co.in.springsecwithhib.model.Authority;
import co.in.springsecwithhib.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityDao userDao;

	@Override
	@Transactional
	public void addAuthority(final Authority user) {

		userDao.addAuthority(user);
	}

	@Override
	@Transactional
	public void deleteAuthority(final Authority user) {

		userDao.deleteAuthority(user);

	}

	@Override
	@Transactional
	public void updateAuthority(final Authority user) {

		userDao.updateAuthority(user);
	}

	@Override
	@Transactional
	public List<Authority> getAllAuthority() {

		return userDao.getAllAuthority();
	}

	@Override
	@Transactional
	public Authority getSingleAuthority(final int id) {

		return userDao.getSingleAuthority(id);
	}

}
