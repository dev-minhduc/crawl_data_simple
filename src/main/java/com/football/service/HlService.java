package com.football.service;

import com.football.domain.Highlight;

public interface HlService {
	Iterable<Highlight> findAll();
	
//	List<Highlight> search(String f);
	
	Highlight findOne(int id_hl);
	
	void save(Highlight highlight);
	
	void delete(int id_hl);
	
	
}
