package com.kayz.dojosninjas.services;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.kayz.dojosninjas.models.Ninja;
import com.kayz.dojosninjas.repositories.NinjaRepo;

@Service
public class NinjaService {
	private final NinjaRepo ninjaRepo;
	
	public NinjaService(NinjaRepo ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	public void create(@Valid Ninja ninja) {
		ninjaRepo.save(ninja);
	}
	
	public Ninja findNinja(Long id) {
		return ninjaRepo.findById(id).orElse(null);
	}
}
