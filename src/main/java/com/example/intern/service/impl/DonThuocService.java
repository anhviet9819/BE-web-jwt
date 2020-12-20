package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.intern.exception.ResourceNotFoundException;
import com.example.intern.model.DonThuoc;
import com.example.intern.repository.DonThuocRepository;
import com.example.intern.service.IDonThuocService;

@Service
@Transactional
public class DonThuocService implements IDonThuocService  {
	
	@Autowired
	private DonThuocRepository donthuocRepository;

	@Override
	public List<DonThuoc> queryByDangKyKhamIdAndTenThuoc(Long dangkykhamId, Long thuocId) {
		if(dangkykhamId == null && thuocId == null) return donthuocRepository.findAll();
		if(dangkykhamId == null){
			List<DonThuoc> donThuoc = donthuocRepository.findByThuocId(thuocId);
			if(donThuoc.size() == 0) throw new ResourceNotFoundException("DonThuoc","thuocid",thuocId);
			return donThuoc;
		}
		if(thuocId == null){
			List<DonThuoc> donThuoc = donthuocRepository.findByDangkykhamId(dangkykhamId);
			if(donThuoc.size() == 0) throw new ResourceNotFoundException("DonThuoc","dangkykhamid",dangkykhamId);
			return donThuoc;
		}
		List<DonThuoc> donThuoc = donthuocRepository.findByThuocIdAndDangkykhamId(dangkykhamId, thuocId);
		if(donThuoc.size() == 0) throw new ResourceNotFoundException("DonThuoc");
		return donThuoc;
	}

	@Override
	public DonThuoc getOneById(Long id) throws ResourceNotFoundException{
		DonThuoc donthuoc = donthuocRepository.findOne(id);
		if(donthuoc == null ) throw new ResourceNotFoundException("DonThuoc");
		return donthuoc;
	}
	
	@Override
	public DonThuoc save(DonThuoc donthuoc) {
		return donthuocRepository.save(donthuoc);
	}
	
	@Override 
	public void delete(Long id) {
		donthuocRepository.delete(id);
	}
	
	@Override
	public void deleteByDangkykhamId(Long dangkykhamid) {
		donthuocRepository.deleteByDangkykhamId(dangkykhamid);
	}
}
