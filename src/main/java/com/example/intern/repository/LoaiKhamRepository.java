package com.example.intern.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.intern.model.LoaiKham;

@Repository
public interface LoaiKhamRepository extends JpaRepository<LoaiKham, Long> {
	List<LoaiKham> findByTenContaining(String ten);
}
