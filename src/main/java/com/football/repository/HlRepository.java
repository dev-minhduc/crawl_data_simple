package com.football.repository;

import org.springframework.data.repository.CrudRepository;

import com.football.domain.Highlight;

public interface HlRepository extends CrudRepository<Highlight, Integer>{

//	List<Highlight> findByTitle(String f);	
}
