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

import co.in.springsecwithhib.dao.UserDao;
import co.in.springsecwithhib.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(final User user) {

		sessionFactory.getCurrentSession().saveOrUpdate(user);

	}

	@Override
	public void deleteUser(final User user) {

		user.setActive(false);
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public void updateUser(final User user) {

		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {

		final Session session = sessionFactory.getCurrentSession();
		final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		final CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		final Root<User> users = criteriaQuery.from(User.class);
		criteriaQuery.select(users);
		final Query query = session.createQuery(criteriaQuery);

		return query.getResultList();
	}

	@Override
	public User getSingleUser(final int id) {

		return sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public User getUserByEmail(final String email) {

		// return sessionFactory.getCurrentSession().get(User.class, email);
		return (User) sessionFactory.getCurrentSession().createQuery("from User where email= :emailId ").setParameter("emailId", email).uniqueResult();
	}

}
