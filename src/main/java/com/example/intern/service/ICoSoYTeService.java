package com.example.intern.service;

import java.util.List;
import com.example.intern.model.CoSoYTe;

public interface ICoSoYTeService {
	
	List<CoSoYTe>queryByTenAndTinh(String ten, Long tinhid);
	CoSoYTe getOneById(Long id);
	List<CoSoYTe> findByTinhId(Long tinhid);
	CoSoYTe save(CoSoYTe cosoyte);
	void delete(Long id);

}
