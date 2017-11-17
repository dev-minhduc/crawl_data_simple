package com.football.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.football.domain.Live;

public interface LiveRepository extends CrudRepository<Live, Integer>{
	
//	List<Live> findByTitle(String f);	
}
