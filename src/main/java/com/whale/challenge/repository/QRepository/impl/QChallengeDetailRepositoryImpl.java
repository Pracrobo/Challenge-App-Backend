package com.whale.challenge.repository.QRepository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.whale.challenge.repository.QRepository.QChallengeDetailRepository;

import javax.persistence.EntityManager;

public class QChallengeDetailRepositoryImpl implements QChallengeDetailRepository {
	
	private final JPAQueryFactory queryFactory;
	
	public QChallengeDetailRepositoryImpl(EntityManager em) {
	    this.queryFactory = new JPAQueryFactory(em);
	}
	
}
