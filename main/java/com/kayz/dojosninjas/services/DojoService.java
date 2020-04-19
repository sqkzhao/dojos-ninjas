package com.kayz.dojosninjas.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.kayz.dojosninjas.models.Dojo;
import com.kayz.dojosninjas.repositories.DojoRepo;

@Service
public class DojoService {
	private final DojoRepo dojoRepo;
	
	public DojoService(DojoRepo dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	public void create(@Valid Dojo dojo) {
		dojoRepo.save(dojo);
	}
	
	public List<Dojo> getAllDojos(){
		return dojoRepo.findAll();
	}
	
	public Dojo findDojo(Long id) {
		return dojoRepo.findById(id).orElse(null);
	}
}
