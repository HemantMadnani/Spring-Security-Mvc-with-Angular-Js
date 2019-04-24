package co.in.springsecwithhib.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import co.in.springsecwithhib.model.Authority;

/**
 * The <code>AuthorityController</code> is used to manage stuffs related to authority in springsecwithhib project.
 * 
 * @author hemant.madnani
 *
 */
@RestController
public class AuthorityController extends BaseController {

	/**
	 * The <code>addAuthority</code> is used to load add an authority page .
	 *
	 * @return
	 */
	@GetMapping("/home/addauthority")
	public ModelAndView addAuthority() {

		return new ModelAndView("addauthority", "authority", new Authority());
	}

	/**
	 * The <code>listAuthority</code> is used to list all authorities.
	 *
	 * @return
	 */
	@GetMapping("/home/viewauthority")
	public ModelAndView listAuthority() {

		return new ModelAndView("listauthority", "authorities", getServiceRegistry().getAuthorityService().getAllAuthority());
	}

	/**
	 * The <code>addAuth</code> is used to save the authority.
	 *
	 * @param authority
	 * @return
	 */
	@PostMapping("/home/addauth")
	public ModelAndView addAuth(@ModelAttribute final Authority authority) {

		final ModelAndView modelAndView = new ModelAndView();
		getServiceRegistry().getAuthorityService().addAuthority(authority);
		modelAndView.setViewName("redirect:/home");

		return modelAndView;
	}
}
