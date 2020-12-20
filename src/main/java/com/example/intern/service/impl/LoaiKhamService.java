package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.exception.ResourceNotFoundException;
import com.example.intern.model.LoaiKham;
import com.example.intern.repository.LoaiKhamRepository;
import com.example.intern.service.ILoaiKhamService;

@Service
public class LoaiKhamService implements ILoaiKhamService {
	
	@Autowired
	LoaiKhamRepository loaikhamRepository;
	
	@Override
	public List<LoaiKham> queryByTen(String ten){
		if(ten == null) return loaikhamRepository.findAll();
		List<LoaiKham> loaikham = loaikhamRepository.findByTenContaining(ten);
		if(loaikham.size() == 0) throw new ResourceNotFoundException("LoaiKham", "ten" ,ten) ;
		
		return loaikham;
	}
	
	@Override
	public LoaiKham getOneById(Long id) throws  ResourceNotFoundException{
		LoaiKham loaikham = loaikhamRepository.findOne(id);
		if(loaikham == null) throw new ResourceNotFoundException("LoaiKham", "id", id);
		return loaikham;
	}
	
	@Override 
	public LoaiKham save(LoaiKham loaikham) {
		return loaikhamRepository.save(loaikham);
	}
	
	@Override
	public void delete (Long id) {
		loaikhamRepository.delete(id);
	}
	
}
