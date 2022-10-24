package com.whale.challenge.repository.QRepository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.whale.challenge.repository.QRepository.QChallengeRepository;

import javax.persistence.EntityManager;

public class QChallengeRepositoryImpl implements QChallengeRepository {
	
	private final JPAQueryFactory queryFactory;
	
	public QChallengeRepositoryImpl(EntityManager em) {
	    this.queryFactory = new JPAQueryFactory(em);
	}
	
}
