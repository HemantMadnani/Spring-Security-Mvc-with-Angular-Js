package co.in.springsecwithhib.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.in.springsecwithhib.dao.AuthorityDao;
import co.in.springsecwithhib.model.Authority;

@Repository
@Transactional
public class AuthorityDaoImpl implements AuthorityDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addAuthority(final Authority user) {

		sessionFactory.getCurrentSession().saveOrUpdate(user);

	}

	@Override
	public void deleteAuthority(final Authority user) {

		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public void updateAuthority(final Authority user) {

		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Authority> getAllAuthority() {

		final Session session = sessionFactory.getCurrentSession();
		final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		final CriteriaQuery<Authority> criteriaQuery = criteriaBuilder.createQuery(Authority.class);
		final Root<Authority> users = criteriaQuery.from(Authority.class);
		criteriaQuery.select(users);
		final Query query = session.createQuery(criteriaQuery);

		return query.getResultList();
	}

	@Override
	public Authority getSingleAuthority(final int id) {

		return sessionFactory.getCurrentSession().get(Authority.class, id);
	}

}
