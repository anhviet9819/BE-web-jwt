package com.example.intern.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.intern.model.Benh;

import java.util.List;

@Repository
public interface BenhRepository extends JpaRepository<Benh, Long> {
	//query
    List<Benh> findByTenContaining(String ten);
}
