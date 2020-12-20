package com.example.intern.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.intern.model.BenhNhan;
import com.example.intern.model.QuanHe;

@Repository
public interface QuanHeRepository extends JpaRepository<QuanHe, Long>{
	//query
	List<QuanHe> findByBenhnhanchinhId(Long benhnhanchinhid);
	List<QuanHe> findByBenhnhanchinhIdAndBenhnhanphuId(Long benhnhanchinhid, Long benhnhanphuid);
	
	@Modifying
	@Query("delete from QuanHe q where q.benhnhanchinh=:benhnhanchinh and q.benhnhanphu=:benhnhanphu")
	void deleleByBenhnhanchinhIdAndBenhnhanphu(@Param("benhnhanchinh")BenhNhan benhnhanchinh, @Param("benhnhanphu") BenhNhan benhnhanphu);
}
