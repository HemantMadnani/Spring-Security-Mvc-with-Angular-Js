package co.in.springsecwithhib.util;

import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class PortalUtils {

	public static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public static String bcryptPasswordEncoder(final String plainText) {

		return passwordEncoder.encode(plainText);
	}

	public static String getRandomAlphaNumericString() {

		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	@SuppressWarnings("unused")
	private static void printJSON(final Object object, final ObjectMapper om) {

		String result;
		try {
			result = om.writerWithDefaultPrettyPrinter().writeValueAsString(object);
			System.out.println(result);
		} catch (final JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
