package co.in.springsecwithhib.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.in.springsecwithhib.dao.SecurityDao;
import co.in.springsecwithhib.model.UserSecurity;

@Repository
@Transactional
public class SecurityDaoImpl implements SecurityDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(final UserSecurity userSecurity) {

		sessionFactory.getCurrentSession().saveOrUpdate(userSecurity);

	}

	@Override
	public void deleteUser(final UserSecurity userSecurity) {

	}

	@Override
	public void updateUser(final UserSecurity userSecurity) {

	}

	@Override
	public List<UserSecurity> getAll() {

		return null;
	}

	@Override
	public UserSecurity getSingleUserSec(final int id) {

		return null;
	}

}
