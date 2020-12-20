package com.example.intern.service;

import java.util.List;

import com.example.intern.model.DonThuoc;

public interface IDonThuocService {
	DonThuoc getOneById(Long id);
	List<DonThuoc> queryByDangKyKhamIdAndTenThuoc(Long dangkykhamId, Long tenthuoc);
	DonThuoc save(DonThuoc donthuoc);
	void delete(Long id);
	void deleteByDangkykhamId(Long dangkykhamid);
}
