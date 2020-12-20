package com.example.intern.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.intern.model.TaiKhoan;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Long> {
	//query
	TaiKhoan findByUsername(String username);
	List<TaiKhoan> findBySdtContaining(String sdt);
	List<TaiKhoan> findByUsernameContainingAndSdtContaining(String username, String sdt);
	Boolean existsByUsername(String username);
}
