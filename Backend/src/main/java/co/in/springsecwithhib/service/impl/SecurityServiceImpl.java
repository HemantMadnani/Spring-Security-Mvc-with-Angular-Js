package co.in.springsecwithhib.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.in.springsecwithhib.dao.SecurityDao;
import co.in.springsecwithhib.model.UserSecurity;
import co.in.springsecwithhib.service.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private SecurityDao securityDao;

	@Override
	@Transactional
	public void addUser(final UserSecurity userSecurity) {

		securityDao.addUser(userSecurity);

	}

}
