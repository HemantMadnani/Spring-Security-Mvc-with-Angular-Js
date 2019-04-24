package co.in.springsecwithhib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceRegistry {

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	@Autowired
	private AuthorityService authorityService;

	/**
	 * @return the roleService
	 */
	public RoleService getRoleService() {

		return roleService;
	}

	/**
	 * @param roleService
	 *            the roleService to set
	 */
	public void setRoleService(final RoleService roleService) {

		this.roleService = roleService;
	}

	/**
	 * @return the userService
	 */
	public UserService getUserService() {

		return userService;
	}

	/**
	 * @param userService
	 *            the userService to set
	 */
	public void setUserService(final UserService userService) {

		this.userService = userService;
	}

	/**
	 * @return the authorityService
	 */
	public AuthorityService getAuthorityService() {

		return authorityService;
	}

	/**
	 * @param authorityService
	 *            the authorityService to set
	 */
	public void setAuthorityService(final AuthorityService authorityService) {

		this.authorityService = authorityService;
	}

}
