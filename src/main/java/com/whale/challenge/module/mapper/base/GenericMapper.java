package com.whale.challenge.module.mapper.base;

public interface GenericMapper<D, E> {

	D toDto(E entity);

	E toEntity(D dto);

}
