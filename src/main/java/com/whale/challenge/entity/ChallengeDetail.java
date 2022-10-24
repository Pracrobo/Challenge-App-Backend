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
* @author : 김하빈(hbkim@bpnsolution.com)
* @description : 챌린지 세부내용 Entity 클래스
* @!
* @?
* @TODO
* @Date : 2022-10-24, 월, 12;18
*/
@SuperBuilder(toBuilder = true)
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "TB_CHALLENGE_DETAIL")
public class ChallengeDetail extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	@Comment("챌린지 새부내용 ID")
	private Integer challengeDetailId;

	@Column(length = 25, nullable = false)
	@Comment("챌린지 세부내용")
	private String description;

	@Column(length = 2, nullable = false)
	@Comment("정렬 순서")
	private Integer order;

	@ManyToOne
	@JoinColumn(name = "challengeId", referencedColumnName = "challengeId")
	@JsonBackReference
	private Challenge challenge;

}