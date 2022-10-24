package com.whale.challenge.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.whale.challenge.entity.base.BaseEntity;
import com.whale.challenge.entity.enums.ChallengeCategory;
import com.whale.challenge.entity.enums.ChallengeDayType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
* @author : 김하빈(danny9643@naver.com)
* @description : 챌린지 Entity 클래스
* @!
* @?
* @TODO
* @Date : 2022-10-24, 월, 12;8
*/
@SuperBuilder(toBuilder = true)
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_CHALLENGE")
public class Challenge extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	@Comment("챌린지 ID")
	private Integer challengeId;

	@Column(length = 25, nullable = false)
	@Comment("챌린지명")
	private String subject;

	@Column(length = 30, nullable = false)
	@Comment("챌린지 카테고리")
	private ChallengeCategory challengeCategory;

	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = false)
	@Comment("챌린지 일자 타입")
	private ChallengeDayType challengeDayType;

	@Column(nullable = false)
	@Comment("시작일")
	private LocalDate startDate;

	@Column
	@Comment("종료일")
	private LocalDate endDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	@Comment("챌린지 생성 사용자 ID")
	private User user;

	@Builder.Default
	@OneToMany(mappedBy = "challenge", orphanRemoval = true, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<ChallengeDay> challengeDays = new ArrayList<>();

}
