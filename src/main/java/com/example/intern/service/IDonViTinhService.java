package com.example.intern.service;

import java.util.List;

import com.example.intern.model.DonViTinh;

public interface IDonViTinhService {
	List<DonViTinh> queryByTen(String ten);
	DonViTinh getOneById(Long id);
	DonViTinh save (DonViTinh donvitinh);
	void delete(Long id);
}
