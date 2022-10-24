package com.whale.challenge.repository.querydsl.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.whale.challenge.repository.querydsl.QUserRepository;

import javax.persistence.EntityManager;

public class QUserRepositoryImpl implements QUserRepository {
	
	private final JPAQueryFactory queryFactory;
	
	public QUserRepositoryImpl(EntityManager em) {
	    this.queryFactory = new JPAQueryFactory(em);
	}
	
}