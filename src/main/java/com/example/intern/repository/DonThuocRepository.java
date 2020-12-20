package com.example.intern.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.intern.model.DonThuoc;

public interface DonThuocRepository extends JpaRepository<DonThuoc, Long> {
	//query
	List<DonThuoc> findByDangkykhamId(long dangkykhamId);
	List<DonThuoc> findByThuocId(Long thuocId);
	List<DonThuoc> findByThuocIdAndDangkykhamId(Long dangkykhamId, Long thuocId);
	void deleteByDangkykhamId(Long dangkykhamid);
}
