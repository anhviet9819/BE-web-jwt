package com.example.intern.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.intern.model.BenhNhan;

@Repository
public interface BenhNhanRepository extends JpaRepository<BenhNhan, Long> {
	//query
	BenhNhan findByTaikhoanId(Long taikhoanid);
	List<BenhNhan> findByTenContaining(String ten);
	List<BenhNhan> findByGioitinh(Boolean gioitinh);
	List<BenhNhan> findByDiachiContaining(String diachi);
	List<BenhNhan> findByTenContainingAndGioitinh(String ten,Boolean gioitinh);
	List<BenhNhan> findByTenContainingAndDiachiContaining(String ten, String diachi);
	List<BenhNhan> findByGioitinhAndDiachiContaining(Boolean gioitinh,String diachi);
	List<BenhNhan> findByTenContainingAndGioitinhAndDiachiContaining(String ten, Boolean gioitinh,String diachi);
}
