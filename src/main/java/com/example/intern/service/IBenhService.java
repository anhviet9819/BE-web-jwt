package com.example.intern.service;

import java.util.List;

import com.example.intern.model.Benh;

public interface IBenhService {
	List<Benh> queryByTen(String ten);
	Benh getOneById(Long id);
	Benh save (Benh benh);
	void delete(Long id);
}
