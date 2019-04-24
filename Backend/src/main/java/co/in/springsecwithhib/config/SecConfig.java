package co.in.springsecwithhib.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import co.in.springsecwithhib.handlers.AuthFailureHandler;
import co.in.springsecwithhib.handlers.AuthSuccessHandler;
import co.in.springsecwithhib.handlers.HttpAuthenticationEntryPoint;
import co.in.springsecwithhib.handlers.HttpLogoutSuccessHandler;
import co.in.springsecwithhib.service.UserSecurityService;

@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan("co.in.springsecwithhib.handlers")
public class SecConfig extends WebSecurityConfigurerAdapter {

	public static final String ROOT = "/user";
	public static final String LOGIN = "/login";

	@Bean
	public UserSecurityService userSecurityService() {

		return new UserSecurityService();
	}

	@Autowired
	private AuthFailureHandler authFailureHandler;

	@Autowired
	private AuthSuccessHandler authSuccessHandler;

	@Autowired
	private HttpAuthenticationEntryPoint httpAuthenticationEntryPoint;

	@Autowired
	private HttpLogoutSuccessHandler httpLogoutSuccessHandler;

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.
	 * authentication.builders.AuthenticationManagerBuilder)
	 */
	@Override
	@Transactional
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {

		final UserDetailsService userDetailsService = userSecurityService();
		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {

		final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(getPasswordEncoder());
		return authenticationProvider;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.
	 * web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(final HttpSecurity http) throws Exception {

		http.anonymous().disable();
		http.cors().configurationSource(corsConfigurationSource());
		http.csrf().disable().exceptionHandling().authenticationEntryPoint(httpAuthenticationEntryPoint).and().authorizeRequests()
				.antMatchers("/home", "/home/**").hasAuthority("ROLE_USER").and().formLogin().permitAll().loginProcessingUrl("/authLog")
				.usernameParameter("email").passwordParameter("password").successHandler(authSuccessHandler).failureHandler(authFailureHandler).and().logout()
				.permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/authLog", HttpMethod.DELETE.name()))
				.logoutSuccessHandler(httpLogoutSuccessHandler).and().sessionManagement().maximumSessions(1);

		// replacing this code with response 200 OK

	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {

		final CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Collections.unmodifiableList(Arrays.asList("*")));
		configuration.setAllowedMethods(Collections.unmodifiableList(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH")));
		configuration.setAllowCredentials(true);
		configuration.setAllowedHeaders(Collections.unmodifiableList(Arrays.asList("Authorization", "Cache-Control", "Content-Type")));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {

		return new BCryptPasswordEncoder();
	}

}
