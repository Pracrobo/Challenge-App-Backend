package com.whale.challenge.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ChallengeDayType {

	A("15일", Duration.ofDays(15)), B("30일", Duration.ofDays(30));

	private String typeNm;
	private Duration duration;

}
