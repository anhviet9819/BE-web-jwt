package com.example.intern.service;

import java.util.Date;
import java.util.List;

import com.example.intern.model.DangKyKham;

public interface IDangKyKhamService {
	List<DangKyKham> queryQuery(Date thoigiandkBegin, Date thoigiandkEnd, Date thoigiankhamBegin, Date thoigiankhamEnd, Boolean trangthaikham, Long benhnhanId, Long bacsiId);
	DangKyKham getOneById(Long id);
	DangKyKham save(DangKyKham dangkykham);
	void delete(Long id);
}

