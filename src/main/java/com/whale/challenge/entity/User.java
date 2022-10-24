package com.whale.challenge.entity;

import com.whale.challenge.entity.base.BaseTimeEntity;
import com.whale.challenge.entity.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@SuperBuilder(toBuilder = true)
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "TB_USER")
public class User extends BaseTimeEntity {

	@Id
	@Column(length = 20)
	@Comment("아이디")
	private String userId;

	@Column(length = 30, nullable = false)
	@Comment("패스워드")
	private String userPass;

	@Column(length = 5, nullable = false)
	@Comment("사용자 명")
	private String userNm;

	@Email
	@Column(length = 30)
	@Comment("이메일")
	private String email;

	@Column(length = 15)
	@Comment("전화번호")
	private String phoneNo;

	@Column(length = 10)
	@Comment("닉네임")
	private String nickname;

	@Enumerated(EnumType.STRING)
	@Column(length = 1)
	@Comment("성별")
	private Gender gender;

	@Column(nullable = false)
	@Comment("생년월일")
	private LocalDate birthDate;

	@Column(nullable = false)
	@Comment("본인 확인용 정보 수집 - 이메일 약관 동의 여부")
	private Boolean emailTermsAgreeYn;

	@Column(nullable = false)
	@Comment("본인 확인용 정보 수집 - 휴대폰 번호 약관 동의 여부")
	private Boolean phoneNoTermsAgreeYn;

	@Column(nullable = false)
	@Comment("알람 수신 여부")
	private Boolean fcmYn;

}
