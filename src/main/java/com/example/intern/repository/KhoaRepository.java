package com.example.intern.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.intern.model.Khoa;

@Repository
public interface KhoaRepository extends JpaRepository<Khoa, Long> {
	//query
	List<Khoa> findByCosoyteId(Long cosoyteid);
	List<Khoa> findByTenContaining(String ten);
	List<Khoa> findByTenContainingAndCosoyteId(String ten, Long cosoyteid);
}
