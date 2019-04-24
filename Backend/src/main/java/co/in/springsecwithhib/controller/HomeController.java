package co.in.springsecwithhib.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import co.in.springsecwithhib.dto.UserDto;
import co.in.springsecwithhib.model.User;

/**
 *
 * The <code>HomeController</code> is used to manage login and registration process in springsecwithhib project.
 *
 * @author hemant.madnani
 *
 */
@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class HomeController extends BaseController {

	/**
	 * The <code>loadIndex</code> is used to load the index page of springsecwithhib project.
	 *
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/")
	public ModelAndView loadIndex(final HttpServletResponse response) {

		return new ModelAndView("home");
	}

	/**
	 * The <code>loadHome</code> is used to load the home page of springsecwithhib project.
	 *
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/home")
	public ModelAndView loadHome(final HttpServletResponse response) {

		return new ModelAndView("welcome");
	}

	/**
	 * The <code>loadLogin</code> is used to load the login page of springsecwithhib project.
	 *
	 * @return
	 */
	@GetMapping("/login")
	public ModelAndView loadLogin() {

		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/");
		if (SecurityContextHolder.getContext().getAuthentication() == null) {
			modelAndView.setViewName("login");
			modelAndView.addObject("user", new User());
		}
		return modelAndView;
	}

	/**
	 * The <code>loadRegistration</code> is used to load the registration page of springsecwithhib project.
	 *
	 * @return
	 */
	@GetMapping("/register")
	public ModelAndView loadRegistration() {

		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", new UserDto());
		modelAndView.setViewName("register");

		return modelAndView;
	}

}
