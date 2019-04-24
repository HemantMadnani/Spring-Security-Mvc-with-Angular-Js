package co.in.springsecwithhib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import co.in.springsecwithhib.service.ServiceRegistry;

/**
 * The <code>BaseController</code> is used to manage basic stuffs that needed in all the controllers in springsecwithhib project.
 *
 * @author hemant.madnani
 *
 */
@RestController
public class BaseController {

	@Autowired
	private ServiceRegistry serviceRegistry;

	/**
	 * @return the serviceRegistry
	 */
	public ServiceRegistry getServiceRegistry() {

		return serviceRegistry;
	}
}
