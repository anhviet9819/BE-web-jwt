package com.example.intern.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.exception.ResourceNotFoundException;
import com.example.intern.model.DonViTinh;
import com.example.intern.repository.DonViTinhRepository;
import com.example.intern.service.IDonViTinhService;

@Service
public class DonViTinhService implements IDonViTinhService {
	
	@Autowired
	private DonViTinhRepository donvitinhRepository;

	@Override
	public List<DonViTinh> queryByTen(String ten) {
		if(ten == null) return donvitinhRepository.findAll();
		List<DonViTinh> donViTinh = donvitinhRepository.findByTenContaining(ten);
		if(donViTinh.size() == 0) throw new ResourceNotFoundException("DonViTinh");
		return donViTinh;
	}

	@Override
	public DonViTinh getOneById(Long id) throws ResourceNotFoundException{
		DonViTinh donvitinh = donvitinhRepository.findOne(id);
		if(donvitinh == null) throw new ResourceNotFoundException("DonViTinh","id", id);
		return donvitinh;
	}
	
	@Override
	public DonViTinh save(DonViTinh donvitinh) {
		return donvitinhRepository.save(donvitinh);
	}
	
	@Override
	public void delete (Long id) {
		donvitinhRepository.delete(id);
	}
}
