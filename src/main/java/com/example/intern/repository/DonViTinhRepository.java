package com.example.intern.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.intern.model.DonViTinh;

import java.util.List;

@Repository
public interface DonViTinhRepository extends JpaRepository<DonViTinh, Long> {
	//query
    List<DonViTinh> findByTenContaining(String ten);
}
