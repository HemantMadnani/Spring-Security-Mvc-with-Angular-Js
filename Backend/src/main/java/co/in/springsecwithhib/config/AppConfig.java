package co.in.springsecwithhib.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * @return
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class[] { RootConfig.class };
	}

	/**
	 * @return
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class[] { MvcConfiguration.class };
	}

	/**
	 * @return
	 */
	@Override
	protected String[] getServletMappings() {

		return new String[] { "/" };
	}

}
