package com.example.intern.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.intern.model.BacSi;

@Repository
public interface BacSiRepository extends JpaRepository<BacSi, Long> {
	//query
	List<BacSi> findByKhoaId(Long khoaid);
	List<BacSi> findByTenContaining(String ten);
	List<BacSi> findByTrinhdo(String trinhdo);
	List<BacSi> findByTenContainingAndKhoaId(String ten,Long khoaid);
	List<BacSi> findByTrinhdoAndKhoaId(String trinhdo,Long khoaid);
	List<BacSi> findByTenContainingAndTrinhdo(String ten,String trinhdo);
	List<BacSi> findByTenContainingAndTrinhdoAndKhoaId(String ten,String trinhdo,Long khoaid);
	
	BacSi findByTaikhoanId (Long taikhoanid);
}
