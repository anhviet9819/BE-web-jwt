package com.example.intern.service;

import java.util.List;

import com.example.intern.model.BacSi;

public interface IBacSiService {
	
	List<BacSi> queryByTenAndTrinhdoAndKhoaId(String ten, String trinhdo, Long khoaid);
	BacSi getOneById(Long id);
	BacSi save(BacSi bacsi);
	void delete(Long id);
}
