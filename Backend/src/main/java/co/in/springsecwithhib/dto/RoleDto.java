package co.in.springsecwithhib.dto;

import java.util.Set;

import co.in.springsecwithhib.model.Role;

public class RoleDto extends Role {

	private Set<String> authlist;

	/**
	 * @return the authlist
	 */
	public Set<String> getAuthlist() {

		return authlist;
	}

	/**
	 * @param authlist
	 *            the authlist to set
	 */
	public void setAuthlist(final Set<String> authlist) {

		this.authlist = authlist;
	}

}
