package com.whale.challenge.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.whale.challenge.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

/**
* @author : 김하빈(danny9643@naver.com)
* @description : 챌린지 일자 콘텐츠 Entity 클래스
* @!
* @?
* @TODO
* @Date : 2022-10-24, 월, 11;44
*/
@SuperBuilder(toBuilder = true)
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "TB_CHALLENGE_DAY")
public class ChallengeDay extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	@Comment("챌린지 일자 콘텐츠 ID")
	private Integer challengeDayId;

	@Column(nullable = false)
	@Comment("스탬프 여부")
	private Boolean stampYn;

	@Column(length = 25)
	@Comment("메모")
	private String memo;

	@Column(length = 200)
	@Comment("첨부 이미지 URL")
	private String imageUrl;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "challengeId", referencedColumnName = "challengeId")
	@JsonBackReference
	@Comment("챌린지 ID")
	private Challenge challenge;

}
