package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.model.BacSi;
import com.example.intern.repository.BacSiRepository;
import com.example.intern.service.IBacSiService;
import com.example.intern.exception.*;

@Service
public class BacSiService implements IBacSiService {

	@Autowired
	private BacSiRepository bacsiRepository;
	
	@Override
	public List<BacSi> queryByTenAndTrinhdoAndKhoaId(String ten, String trinhdo, Long khoaid) throws ResourceNotFoundException{
		if(ten == null && trinhdo == null && khoaid == null) return bacsiRepository.findAll();
		
		if(ten == null && khoaid == null ) {
			List<BacSi> bacsi = bacsiRepository.findByTrinhdo(trinhdo);
			if( bacsi.size() ==0 ) throw new ResourceNotFoundException("BacSi","trinhdo",trinhdo);
			return bacsi;
		}
		
		if(trinhdo == null && khoaid == null ) {
			List<BacSi> bacsi = bacsiRepository.findByTenContaining(ten);
			if( bacsi.size() ==0 ) throw new ResourceNotFoundException("BacSi","ten",ten);
			return bacsi;
		}
		
		if(ten == null && trinhdo == null) {
			List<BacSi> bacsi = bacsiRepository.findByKhoaId(khoaid);
			if( bacsi.size() ==0 ) throw new ResourceNotFoundException("BacSi", "khoaid",khoaid);
			return bacsi;
		}
		
		if(ten == null) {
			List<BacSi> bacsi = bacsiRepository.findByTrinhdoAndKhoaId(trinhdo,khoaid);
			if( bacsi.size() == 0) throw new ResourceNotFoundException("BacSi");
			return bacsi;
		}
		
		if(trinhdo == null) {
			List<BacSi> bacsi = bacsiRepository.findByTenContainingAndKhoaId(ten,khoaid);
			if( bacsi.size() == 0) throw new ResourceNotFoundException("BacSi");
			return bacsi;
		}
		
		if(khoaid == null) {
			List<BacSi> bacsi = bacsiRepository.findByTenContainingAndTrinhdo(ten,trinhdo);
			if( bacsi.size() == 0) throw new ResourceNotFoundException("BacSi");
			return bacsi;
		}
		
		List<BacSi> bacsi = bacsiRepository.findByTenContainingAndTrinhdoAndKhoaId(ten,trinhdo,khoaid);
		if( bacsi.size() ==0 ) throw new ResourceNotFoundException("BacSi");
		return bacsi;
	}
	
	@Override
	public BacSi getOneById(Long id) throws ResourceNotFoundException{
		BacSi bacsi = bacsiRepository.findOne(id);
		if(bacsi == null) throw new ResourceNotFoundException("BacSi","id",id);
		return bacsi;
	}
	
//	@Override
//	public BacSi findByTaikhoanId(Long taikhoanid) throws ResourceNotFoundException{
//		BacSi bacsi = bacsiRepository.findByTaikhoanId(taikhoanid);
//		if(bacsi == null) throw new ResourceNotFoundException("BacSi","taikhoanid",taikhoanid);
//		return bacsi;
//	}
	
	@Override
	public BacSi save(BacSi bacsi) {
		if(bacsi.getId() == null) return bacsiRepository.save(bacsi);
		BacSi bacsi2 = bacsiRepository.getOne(bacsi.getId());
		if(bacsi2 != null) throw new DuplicateIdException("BacSi", bacsi.getId());
		return bacsiRepository.save(bacsi);
	}
	
	@Override
	public void delete(Long id) {
		bacsiRepository.delete(id);
	}
}
