package co.in.springsecwithhib.handlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Used to handle failure if credentials are invalid.
 *
 * @author hemant.madnani
 *
 */
@Component
public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Bean
	public ObjectMapper objectMapper() {

		return new ObjectMapper();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler#onAuthenticationFailure(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, org.springframework.security.core.AuthenticationException)
	 */
	@Override
	public void onAuthenticationFailure(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException exception)
			throws IOException, ServletException {

		System.out.println("Failure Handler======" + exception);
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		final PrintWriter printWriter = response.getWriter();
		objectMapper().writeValue(printWriter,
				exception instanceof BadCredentialsException ? new BadCredentialsException("Username or Password is incorrect") : exception);
		printWriter.flush();
	}

}
