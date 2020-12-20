package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.exception.ResourceNotFoundException;
import com.example.intern.model.Thuoc;
import com.example.intern.repository.ThuocRepository;
import com.example.intern.service.IThuocService;

@Service
public class ThuocService implements IThuocService {
	
	@Autowired
	private ThuocRepository thuocRepository;

	@Override
	public List<Thuoc> queryByTen(String ten) {
		if(ten == null) return thuocRepository.findAll();
		List<Thuoc> thuoc = thuocRepository.findByTenContaining(ten);
		if(thuoc.size() == 0) throw new ResourceNotFoundException("Thuoc");
		return thuoc;
	}

	@Override
	public Thuoc getOneById(Long id) throws ResourceNotFoundException{
		Thuoc thuoc = thuocRepository.findOne(id);
		if( thuoc == null ) throw new ResourceNotFoundException("Thuoc", "id", id);
		return thuoc;
	}
	
	@Override
	public Thuoc save(Thuoc thuoc) {
		return thuocRepository.save(thuoc);
	}
	
	@Override
	public void delete(Long id) {
		thuocRepository.delete(id);
	}
	
}
