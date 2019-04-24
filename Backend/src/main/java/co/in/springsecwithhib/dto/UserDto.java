package co.in.springsecwithhib.dto;

import co.in.springsecwithhib.model.User;

public class UserDto extends User {

	private String confirmPassword;

	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {

		return confirmPassword;
	}

	/**
	 * @param confirmPassword
	 *            the confirmPassword to set
	 */
	public void setConfirmPassword(final String confirmPassword) {

		this.confirmPassword = confirmPassword;
	}

}
