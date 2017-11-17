package com.football.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.domain.Live;
import com.football.repository.LiveRepository;

@Service
public class LiveServiceImpl implements LiveService{

	@Autowired
	private LiveRepository liveRepository;
	
	@Override
	public Iterable<Live> findAll() {
		return liveRepository.findAll();
	}

//	@Override
//	public List<Live> search(String f) {
//		return liveRepository.findByName(f);
//	}

	@Override
	public Live findOne(int id_live) {
		return liveRepository.findOne(id_live);
	}

	@Override
	public void save(Live live) {
		liveRepository.save(live);
	}

	@Override
	public void delete(int id_live) {
		liveRepository.delete(id_live);
	}


	
}
