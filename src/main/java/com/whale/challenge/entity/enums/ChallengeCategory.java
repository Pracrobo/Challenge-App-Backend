package com.whale.challenge.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ChallengeCategory {

	SPORTS("스포츠"),
	DEVELOP("자기개발"),
	ART("예술활동"),
	HABIT("습관 만들기"),
	ETC("기타");

	private String hanName;

}
