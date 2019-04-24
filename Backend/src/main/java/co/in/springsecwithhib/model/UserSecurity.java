package co.in.springsecwithhib.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserSecurity implements UserDetails {

	private static final long serialVersionUID = 1L;

	private User user;
	private final List<String> authorities;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		final List<GrantedAuthority> authorities = new ArrayList<>();
		this.authorities.forEach(authority -> authorities.add(new SimpleGrantedAuthority(authority)));
		System.err.println("authorities =====" + authorities);
		return authorities;
	}

	public UserSecurity(final User user, final List<String> authorities) {

		this.user = user;
		this.authorities = authorities;
	}

	@Override
	public String getPassword() {

		return user.getPassword();
	}

	@Override
	public String getUsername() {

		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return user.isActive();
	}

	public User getUser() {

		return user;
	}

	public void setUser(final User user) {

		this.user = user;
	}

}
