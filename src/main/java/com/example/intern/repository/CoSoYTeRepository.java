package com.example.intern.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.intern.model.CoSoYTe;

@Repository
public interface CoSoYTeRepository extends JpaRepository<CoSoYTe, Long> {
	// query
	//	@Query("select c from dm_cosoyte c join dm_tinh where tinhid = ?1 ")
	//	public List<CoSoYTe> getAllCoSoYTefromTinhById(Long id);
	List<CoSoYTe> findByTinhId (Long tinhid);
	List<CoSoYTe> findByTenContaining(String ten);
	List<CoSoYTe> findByTenContainingAndTinhId(String ten,Long tinhid);
}
