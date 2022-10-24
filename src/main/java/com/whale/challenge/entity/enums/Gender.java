package com.whale.challenge.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Gender {

	F("FEMALE", "여성"), M("MALE", "남성");

	private String fullName;
	private String hanName;

}
