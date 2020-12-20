package com.example.intern.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.intern.model.DangKyKham;

@Repository
public interface DangKyKhamRepository extends JpaRepository<DangKyKham, Long> {
	//query
	List<DangKyKham> findAllByThoigiandkBetweenAndThoigiankhamBetween(Date thoigiandkBegin, Date thoigiandkEnd, Date thoigiankhamBegin, Date thoigiankhamEnd);
	List<DangKyKham> findAllByThoigiandkBetweenAndThoigiankhamBetweenAndTrangthaikham(Date thoigiandkBegin, Date thoigiandkEnd, Date thoigiankhamBegin, Date thoigiankhamEnd, Boolean trangthaikham);
	List<DangKyKham> findAllByThoigiandkBetweenAndThoigiankhamBetweenAndBenhnhanId(Date thoigiandkBegin, Date thoigiandkEnd, Date thoigiankhamBegin, Date thoigiankhamEnd, Long benhnhanid);
	List<DangKyKham> findAllByThoigiandkBetweenAndThoigiankhamBetweenAndBacsiId(Date thoigiandkBegin, Date thoigiandkEnd, Date thoigiankhamBegin, Date thoigiankhamEnd, Long bacsiid);
	List<DangKyKham> findAllByThoigiandkBetweenAndThoigiankhamBetweenAndTrangthaikhamAndBacsiId(Date thoigiandkBegin, Date thoigiandkEnd, Date thoigiankhamBegin, Date thoigiankhamEnd, Boolean trangthaikham, Long bacsiid);
	List<DangKyKham> findAllByThoigiandkBetweenAndThoigiankhamBetweenAndBenhnhanIdAndBacsiId(Date thoigiandkBegin,Date thoigiandkEnd,Date thoigiankhamBegin,Date thoigiankhamEnd,Long benhnhanid,Long bacsiId);
 	List<DangKyKham> findAllByThoigiandkBetweenAndThoigiankhamBetweenAndTrangthaikhamAndBenhnhanId(Date thoigiandkBegin, Date thoigiandkEnd, Date thoigiankhamBegin, Date thoigiankhamEnd, Boolean trangthaikham, Long benhnhanid);
	List<DangKyKham> findAllByThoigiandkBetweenAndThoigiankhamBetweenAndTrangthaikhamAndBacsiIdAndBenhnhanId(Date thoigiandkBegin, Date thoigiandkEnd, Date thoigiankhamBegin, Date thoigiankhamEnd, Boolean trangthaikham, Long bacsiid, Long benhnhanid);
}
