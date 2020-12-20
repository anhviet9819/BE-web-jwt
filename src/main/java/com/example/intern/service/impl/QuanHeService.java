package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.intern.exception.ResourceNotFoundException;
import com.example.intern.model.BenhNhan;
import com.example.intern.model.QuanHe;
import com.example.intern.repository.QuanHeRepository;
import com.example.intern.service.IQuanHeService;

@Service
@Transactional
public class QuanHeService implements IQuanHeService {
	
	@Autowired
	private QuanHeRepository quanheRepository;
	
		
	@Override 
	public 	List<QuanHe> queryByBenhnhanchinhIdAndBenhnhanphuId(Long benhnhanchinhid, Long benhnhanphuid) throws ResourceNotFoundException{
		if(benhnhanchinhid == null && benhnhanphuid == null ) return quanheRepository.findAll();
		if(benhnhanphuid == null) {
			List<QuanHe> quanhe = quanheRepository.findByBenhnhanchinhId(benhnhanchinhid);
			if(quanhe == null ) throw new ResourceNotFoundException("QuanHe", "benhnhanchinhid", benhnhanchinhid);
			return quanhe;
		}
		List<QuanHe> quanhe = quanheRepository.findByBenhnhanchinhIdAndBenhnhanphuId(benhnhanchinhid,benhnhanphuid);
		if(quanhe == null ) throw new ResourceNotFoundException("QuanHe");
		return quanhe;
	}
	
	@Override
	public QuanHe getOneById(Long id) throws ResourceNotFoundException{
		QuanHe quanhe = quanheRepository.findOne(id);
		if(quanhe == null ) throw new ResourceNotFoundException("QuanHe", "id", id);
		return quanhe;
	}
	
	@Override
	public QuanHe save(QuanHe quanhe) {
		return quanheRepository.save(quanhe);
	}
	
	@Override
	public void deleleByBenhnhanchinhIdAndBenhnhanphu(BenhNhan benhnhanchinh, BenhNhan benhnhanphu) {
		quanheRepository.deleleByBenhnhanchinhIdAndBenhnhanphu(benhnhanchinh, benhnhanphu);
	}
	
	
}




