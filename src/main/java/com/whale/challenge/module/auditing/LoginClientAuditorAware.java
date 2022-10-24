package com.whale.challenge.module.auditing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

@Slf4j
@Component
public class LoginClientAuditorAware implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null || !authentication.isAuthenticated() ||
				authentication instanceof AnonymousAuthenticationToken) {
			return Optional.empty();
		}

		Object principal = authentication.getPrincipal();
		String clientId = null;

		try {
			clientId = (String) principal.getClass().getMethod("getUsername").invoke(principal);

		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
		         | SecurityException e) {
			e.printStackTrace();
		}

		if (clientId == null) {
			log.error("유효한 클라이언트 아이디가 없습니다. : {}", clientId);
		}

		return Optional.of(clientId);
	}

}
