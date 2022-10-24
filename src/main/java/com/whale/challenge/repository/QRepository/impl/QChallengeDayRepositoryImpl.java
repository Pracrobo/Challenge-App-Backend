package com.whale.challenge.repository.QRepository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.whale.challenge.repository.QRepository.QChallengeDayRepository;

import javax.persistence.EntityManager;

public class QChallengeDayRepositoryImpl implements QChallengeDayRepository {
	
	private final JPAQueryFactory queryFactory;
	
	public QChallengeDayRepositoryImpl(EntityManager em) {
	    this.queryFactory = new JPAQueryFactory(em);
	}
	
}
