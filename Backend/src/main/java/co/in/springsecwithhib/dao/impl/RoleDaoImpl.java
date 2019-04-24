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

import co.in.springsecwithhib.dao.RoleDao;
import co.in.springsecwithhib.model.Role;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addRole(final Role user) {

		sessionFactory.getCurrentSession().saveOrUpdate(user);

	}

	@Override
	public void deleteRole(final Role user) {

		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public void updateRole(final Role user) {

		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAllRole() {

		final Session session = sessionFactory.getCurrentSession();
		final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		final CriteriaQuery<Role> criteriaQuery = criteriaBuilder.createQuery(Role.class);
		final Root<Role> users = criteriaQuery.from(Role.class);
		criteriaQuery.select(users);
		final Query query = session.createQuery(criteriaQuery);

		return query.getResultList();
	}

	@Override
	public Role getSingleRole(final int id) {

		return sessionFactory.getCurrentSession().get(Role.class, id);
	}

	@Override
	public Role getRolebyRoleName(final String name) {

		return (Role) sessionFactory.getCurrentSession().createQuery("from Role where name= :roleName").setParameter("roleName", name).uniqueResult();
	}

}
