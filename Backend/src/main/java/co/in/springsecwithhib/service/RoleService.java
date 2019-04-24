package co.in.springsecwithhib.service;

import java.util.List;

import co.in.springsecwithhib.model.Role;

public interface RoleService {

	public void addRole(Role user);

	public void deleteRole(Role user);

	public void updateRole(Role user);

	public List<Role> getAllRole();

	public Role getSingleRole(int id);

	public Role getRoleByRoleName(String name);
}
