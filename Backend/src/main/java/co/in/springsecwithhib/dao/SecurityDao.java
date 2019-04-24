package co.in.springsecwithhib.dao;

import java.util.List;

import co.in.springsecwithhib.model.UserSecurity;

public interface SecurityDao {

	public void addUser(UserSecurity userSecurity);

	public void deleteUser(UserSecurity userSecurity);

	public void updateUser(UserSecurity userSecurity);

	public List<UserSecurity> getAll();

	public UserSecurity getSingleUserSec(int id);

}
