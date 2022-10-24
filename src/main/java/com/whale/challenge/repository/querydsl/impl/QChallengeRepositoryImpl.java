package com.whale.challenge.repository.querydsl.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.whale.challenge.repository.querydsl.QChallengeRepository;

import javax.persistence.EntityManager;

public class QChallengeRepositoryImpl implements QChallengeRepository {
	
	private final JPAQueryFactory queryFactory;
	
	public QChallengeRepositoryImpl(EntityManager em) {
	    this.queryFactory = new JPAQueryFactory(em);
	}
	
}
