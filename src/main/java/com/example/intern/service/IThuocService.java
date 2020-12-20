package com.example.intern.service;

import java.util.List;

import com.example.intern.model.Thuoc;

public interface IThuocService {
	List<Thuoc> queryByTen(String ten);
	Thuoc getOneById(Long id);
	Thuoc save (Thuoc thuoc);
	void delete(Long id);
}
