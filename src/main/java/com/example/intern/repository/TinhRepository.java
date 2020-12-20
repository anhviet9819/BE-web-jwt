package com.example.intern.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.intern.model.Tinh;

@Repository
public interface TinhRepository extends JpaRepository<Tinh, Long> {
	// more query here
	List<Tinh> findByTenContaining(String ten);
}
