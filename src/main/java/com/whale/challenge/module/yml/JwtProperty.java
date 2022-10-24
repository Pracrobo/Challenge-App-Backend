package com.whale.challenge.module.yml;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@ConfigurationProperties("jwt")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtProperty {
	private String secret;
	private Duration accessTokenValidity;
	private Duration refreshTokenValidity;

	public Long getAccessTokenValidity() {
		return accessTokenValidity.toMillis();
	}

	public Long getRefreshTokenValidity() {
		return refreshTokenValidity.toMillis();
	}
}
