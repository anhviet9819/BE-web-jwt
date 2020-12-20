package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.exception.ResourceNotFoundException;
import com.example.intern.model.CoSoYTe;
import com.example.intern.repository.CoSoYTeRepository;
import com.example.intern.service.ICoSoYTeService;

@Service
public class CoSoYTeService implements ICoSoYTeService {
	
	@Autowired
	public CoSoYTeRepository cosoyteRepository;
	
	
	@Override
	public List<CoSoYTe> queryByTenAndTinh(String ten,Long tinhid) throws ResourceNotFoundException{
		if(ten == null && tinhid == null) return cosoyteRepository.findAll();
		if(tinhid == null ) {
			List<CoSoYTe> cosoyte = cosoyteRepository.findByTenContaining(ten);
			if( cosoyte.size() ==0 ) throw new ResourceNotFoundException("CoSoYTe","ten",ten);
			return cosoyte;
		}
		if(ten == null) {
			List<CoSoYTe> cosoyte = cosoyteRepository.findByTinhId(tinhid);
			if( cosoyte.size() ==0 ) throw new ResourceNotFoundException("CoSoYTe", "tinhid",tinhid);
			return cosoyte;
		}
		List<CoSoYTe> cosoyte = cosoyteRepository.findByTenContainingAndTinhId(ten,tinhid);
		if( cosoyte.size() ==0 ) throw new ResourceNotFoundException("CoSoYTe");
		return cosoyte;
	}
	
	@Override
	public CoSoYTe getOneById(Long id) throws ResourceNotFoundException{
		CoSoYTe cosoyte =  cosoyteRepository.findOne(id);
		if(cosoyte == null ) throw new ResourceNotFoundException("CoSoYTe","id",id);
		return cosoyte;
	}
	
	@Override
	public List<CoSoYTe> findByTinhId(Long tinhid) throws ResourceNotFoundException{
		List<CoSoYTe> cosoyte = cosoyteRepository.findByTinhId(tinhid);
		if(cosoyte == null ) throw new ResourceNotFoundException("CoSoYTe","tinhid", tinhid);
		return cosoyte;
	}
	
	@Override
	public CoSoYTe save(CoSoYTe cosoyte) {
		return cosoyteRepository.save(cosoyte);
	}
	
	@Override
	public void delete(Long id) {
		cosoyteRepository.delete(id);
	}
}
