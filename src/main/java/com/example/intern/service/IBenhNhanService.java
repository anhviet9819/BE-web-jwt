package com.example.intern.service;

import java.util.List;

import com.example.intern.model.BenhNhan;

public interface IBenhNhanService {
	
	List<BenhNhan> queryByTenAndNgaysinhAndDiachi(String ten, Boolean gioitinh, String diachi);
	BenhNhan getOneById(Long id);
	BenhNhan save(BenhNhan benhnhan);
	void delete(Long id);
}
