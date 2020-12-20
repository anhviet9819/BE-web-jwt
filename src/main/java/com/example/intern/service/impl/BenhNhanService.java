package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.intern.model.BenhNhan;
import com.example.intern.repository.BenhNhanRepository;
import com.example.intern.service.IBenhNhanService;
import com.example.intern.exception.*;

@Service
@Transactional
public class BenhNhanService implements IBenhNhanService {
	
	@Autowired
	private BenhNhanRepository benhnhanRepository;
	
	@Override
	public List<BenhNhan> queryByTenAndNgaysinhAndDiachi(String ten, Boolean gioitinh, String diachi) throws ResourceNotFoundException{
		if(ten == null && gioitinh == null && diachi == null) return benhnhanRepository.findAll();
		
		if(ten == null && diachi == null ) {
			List<BenhNhan> benhnhan = benhnhanRepository.findByGioitinh(gioitinh);
			if( benhnhan.size() ==0 ) throw new ResourceNotFoundException("BenhNhan","gioitinh",gioitinh);
			return benhnhan;
		}
		
		if(gioitinh == null && diachi == null ) {
			List<BenhNhan> benhnhan = benhnhanRepository.findByTenContaining(ten);
			if( benhnhan.size() ==0 ) throw new ResourceNotFoundException("BenhNhan","ten",ten);
			return benhnhan;
		}
		
		if(ten == null && gioitinh == null) {
			List<BenhNhan> benhnhan = benhnhanRepository.findByDiachiContaining(diachi);
			if( benhnhan.size() ==0 ) throw new ResourceNotFoundException("BenhNhan", "diachi",diachi);
			return benhnhan;
		}
		
		if(ten == null) {
			List<BenhNhan> benhnhan = benhnhanRepository.findByGioitinhAndDiachiContaining(gioitinh,diachi);
			if( benhnhan.size() == 0) throw new ResourceNotFoundException("BenhNhan");
			return benhnhan;
		}
		
		if(gioitinh == null) {
			List<BenhNhan> benhnhan = benhnhanRepository.findByTenContainingAndDiachiContaining(ten,diachi);
			if( benhnhan.size() == 0) throw new ResourceNotFoundException("BenhNhan");
			return benhnhan;
		}
		
		if(diachi == null) {
			List<BenhNhan> benhnhan = benhnhanRepository.findByTenContainingAndGioitinh(ten,gioitinh);
			if( benhnhan.size() == 0) throw new ResourceNotFoundException("BenhNhan");
			return benhnhan;
		}
		
		List<BenhNhan> benhnhan = benhnhanRepository.findByTenContainingAndGioitinhAndDiachiContaining(ten,gioitinh,diachi);
		if( benhnhan.size() ==0 ) throw new ResourceNotFoundException("BenhNhan");
		return benhnhan;
	}
	
	@Override
	public BenhNhan getOneById(Long id) throws ResourceNotFoundException{
		BenhNhan benhnhan = benhnhanRepository.getOne(id);
		if(benhnhan == null ) throw new ResourceNotFoundException("BenhNhan","id",id);
		return benhnhan;
	}
	
//	@Override
//	public BenhNhan findByTaikhoanId(Long taikhoanid) throws ResourceNotFoundException{
//		BenhNhan benhnhan = benhnhanRepository.findByTaikhoanId(taikhoanid);
//		if(benhnhan == null ) throw new ResourceNotFoundException("BenhNhan","taikhoanid",taikhoanid);
//		return benhnhan;
//	}
	
	@Override
	public BenhNhan save(BenhNhan benhnhan) {
		return benhnhanRepository.save(benhnhan);
	}
	
	@Override
	public void delete(Long id) {
		benhnhanRepository.delete(id);
	}
	
	
}
