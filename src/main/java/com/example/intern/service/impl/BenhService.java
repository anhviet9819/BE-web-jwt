package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.exception.ResourceNotFoundException;
import com.example.intern.model.Benh;
import com.example.intern.repository.BenhRepository;
import com.example.intern.service.IBenhService;

@Service
public class BenhService implements IBenhService {
	
	@Autowired
	private BenhRepository benhRepository;

	@Override
	public List<Benh> queryByTen(String ten) {
		if(ten == null) return benhRepository.findAll();
		List<Benh> benh = benhRepository.findByTenContaining(ten);
		if(benh.size() == 0) throw new ResourceNotFoundException("Benh");
		return benh;
	}

	@Override
	public Benh getOneById(Long id) throws ResourceNotFoundException{
		Benh benh = benhRepository.findOne(id);
		if(benh == null ) throw new ResourceNotFoundException("Benh" , "id" ,id);
		return benh;
	}
	
	@Override
	public Benh save(Benh benh) {
		return benhRepository.save(benh);
	}
	
	@Override
	public void delete(Long id) {
		benhRepository.delete(id);
	}
}
