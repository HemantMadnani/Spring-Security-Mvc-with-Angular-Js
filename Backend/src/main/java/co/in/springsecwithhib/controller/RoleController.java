package co.in.springsecwithhib.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import co.in.springsecwithhib.dto.RoleDto;
import co.in.springsecwithhib.model.Role;

/**
 * The <code>RoleController</code> is used manage the role management process in springsecwithhib project.
 *
 * @author hemant.madnani
 *
 */
@RestController
public class RoleController extends BaseController {

	/**
	 * The <code>viewRoles</code> is used to view all the roles.
	 *
	 * @return
	 */
	@GetMapping("/home/viewroles")
	public ModelAndView viewRoles() {

		return new ModelAndView("listroles", "roles", getServiceRegistry().getRoleService().getAllRole());
	}

	/**
	 * The <code>addRole</code> is used to load the add role page.
	 *
	 * @return
	 */
	@GetMapping("/home/addrole")
	public ModelAndView addRole() {

		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("authorities", getServiceRegistry().getAuthorityService().getAllAuthority());
		modelAndView.addObject("role", new RoleDto());
		modelAndView.setViewName("addrole");
		return modelAndView;
	}

	/**
	 * The <code>saveRole</code> is used to save the role.
	 *
	 * @param roleDto
	 * @return
	 */
	@PostMapping("/home/saverole")
	public ModelAndView saveRole(@ModelAttribute final RoleDto roleDto) {

		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/home");
		roleDto.getAuthlist()
				.forEach(authid -> roleDto.getAuthorities().add(getServiceRegistry().getAuthorityService().getSingleAuthority(Integer.parseInt(authid))));
		final Role role = new Role();
		BeanUtils.copyProperties(roleDto, role, "authlist");
		getServiceRegistry().getRoleService().addRole(role);
		return modelAndView;
	}

}
