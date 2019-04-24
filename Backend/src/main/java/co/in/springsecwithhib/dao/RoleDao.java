package co.in.springsecwithhib.dao;

import java.util.List;

import co.in.springsecwithhib.model.Role;

public interface RoleDao {

	public void addRole(Role user);

	public void deleteRole(Role user);

	public void updateRole(Role user);

	public List<Role> getAllRole();

	public Role getSingleRole(int id);

	public Role getRolebyRoleName(String name);

}
