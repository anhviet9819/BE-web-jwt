package com.example.intern.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.intern.exception.ResourceNotFoundException;
import com.example.intern.model.DangKyKham;
import com.example.intern.repository.DangKyKhamRepository;
import com.example.intern.service.IDangKyKhamService;

@Service
public class DangKyKhamService implements IDangKyKhamService {

	@Autowired
	private DangKyKhamRepository dangkykhamRepository;

	@Override
	public List<DangKyKham> queryQuery(Date thoigiandkBegin, Date thoigiandkEnd, Date thoigiankhamBegin, Date thoigiankhamEnd, Boolean trangthaikham, Long benhnhanId, Long bacsiId)
	{
		if(bacsiId == null && benhnhanId == null && trangthaikham == null){
			List<DangKyKham> dangKyKham = dangkykhamRepository.findAllByThoigiandkBetweenAndThoigiankhamBetween(thoigiandkBegin,thoigiandkEnd,thoigiankhamBegin,thoigiankhamEnd);
			if(dangKyKham.size() == 0) throw new ResourceNotFoundException("dangykham");
			return dangKyKham;
		}
		if(bacsiId == null && benhnhanId == null){
			List<DangKyKham> dangKyKham = dangkykhamRepository.findAllByThoigiandkBetweenAndThoigiankhamBetweenAndTrangthaikham(thoigiandkBegin,thoigiandkEnd,thoigiankhamBegin,thoigiankhamEnd,trangthaikham);
			if(dangKyKham.size() == 0) throw new ResourceNotFoundException("dangkykham");
			return dangKyKham;
		}
		if(bacsiId == null && trangthaikham == null){
			List<DangKyKham> dangKyKham = dangkykhamRepository.findAllByThoigiandkBetweenAndThoigiankhamBetweenAndBenhnhanId(thoigiandkBegin,thoigiandkEnd,thoigiankhamBegin,thoigiankhamEnd,benhnhanId);
			if(dangKyKham.size() == 0) throw new ResourceNotFoundException("dangkykham");
			return dangKyKham;
		}
		if(benhnhanId == null && trangthaikham == null){
			List<DangKyKham> dangKyKham = dangkykhamRepository.findAllByThoigiandkBetweenAndThoigiankhamBetweenAndBacsiId(thoigiandkBegin,thoigiandkEnd,thoigiankhamBegin,thoigiankhamEnd,bacsiId);
			if(dangKyKham.size() == 0) throw new ResourceNotFoundException("dangkykham");
			return dangKyKham;
		}
		if(bacsiId == null){
			List<DangKyKham> dangKyKham = dangkykhamRepository.findAllByThoigiandkBetweenAndThoigiankhamBetweenAndTrangthaikhamAndBenhnhanId(thoigiandkBegin,thoigiandkEnd,thoigiankhamBegin,thoigiankhamEnd,trangthaikham,benhnhanId);
			if(dangKyKham.size() == 0) throw new ResourceNotFoundException("dangkykham","benhnhanId",benhnhanId);
			return dangKyKham;
		}
		if(benhnhanId == null){
			List<DangKyKham> dangKyKham = dangkykhamRepository.findAllByThoigiandkBetweenAndThoigiankhamBetweenAndTrangthaikhamAndBacsiId(thoigiandkBegin,thoigiandkEnd,thoigiankhamBegin,thoigiankhamEnd,trangthaikham,bacsiId);
			if(dangKyKham.size() == 0) throw new ResourceNotFoundException("dangkykham","bacsiId",bacsiId);
			return dangKyKham;
		}
		if(trangthaikham == null){
			List<DangKyKham> dangKyKham = dangkykhamRepository.findAllByThoigiandkBetweenAndThoigiankhamBetweenAndBenhnhanIdAndBacsiId(thoigiandkBegin,thoigiandkEnd,thoigiankhamBegin,thoigiankhamEnd,benhnhanId,bacsiId);
			if(dangKyKham.size() == 0) throw new ResourceNotFoundException("dangkykham","bacsiId",bacsiId);
			return dangKyKham;
		}
		List<DangKyKham> dangKyKham = dangkykhamRepository.findAllByThoigiandkBetweenAndThoigiankhamBetweenAndTrangthaikhamAndBacsiIdAndBenhnhanId(thoigiandkBegin,thoigiandkEnd,thoigiankhamBegin,thoigiankhamEnd,trangthaikham,bacsiId,benhnhanId);
 		if(dangKyKham.size() == 0) throw new ResourceNotFoundException("Dangkykham");
		return dangKyKham;
	}

	@Override
	public DangKyKham getOneById(Long id) throws ResourceNotFoundException{
		DangKyKham dangkykham = dangkykhamRepository.findOne(id);
		if(dangkykham == null ) throw new ResourceNotFoundException("DangKyKham","id",id);
		return dangkykham;
	}

	@Override
	public DangKyKham save(DangKyKham dangkykham) {
		return dangkykhamRepository.save(dangkykham);
	}

	@Override
	public void delete(Long id) {
		dangkykhamRepository.delete(id);
	}
}
















