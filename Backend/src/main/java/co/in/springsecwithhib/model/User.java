package co.in.springsecwithhib.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(generator = "increment", strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "active")
	@Type(type = "true_false")
	private boolean active;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"), name = "user_roles")
	private Set<Role> roles = new HashSet<>();

	public User(final String email, final String password) {

		super();
		this.email = email;
		this.password = password;
	}

	public User() {

	}

	public int getId() {

		return id;
	}

	public void setId(final int id) {

		this.id = id;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(final String email) {

		this.email = email;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(final String password) {

		this.password = password;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {

		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(final boolean active) {

		this.active = active;
	}

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {

		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(final Set<Role> roles) {

		this.roles = roles;
	}

}
