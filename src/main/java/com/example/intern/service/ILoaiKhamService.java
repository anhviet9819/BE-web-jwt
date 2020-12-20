package com.example.intern.service;

import java.util.List;

import com.example.intern.model.LoaiKham;

public interface ILoaiKhamService {

	List<LoaiKham> queryByTen(String ten);
	LoaiKham getOneById(Long id);
	LoaiKham save(LoaiKham loaikham);
	void delete(Long id);
}
