package co.in.springsecwithhib.dao;

import java.util.List;

import co.in.springsecwithhib.model.Authority;

public interface AuthorityDao {

	public void addAuthority(Authority user);

	public void deleteAuthority(Authority user);

	public void updateAuthority(Authority user);

	public List<Authority> getAllAuthority();

	public Authority getSingleAuthority(int id);

}
