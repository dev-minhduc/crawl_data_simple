package com.football.service;

import java.util.List;

import com.football.domain.Live;

public interface LiveService {
	
	Iterable<Live> findAll();
	
//	List<Live> search(String f);
	
	Live findOne(int id_live);
	
	void save(Live live);
	
	void delete(int id_live);
}
