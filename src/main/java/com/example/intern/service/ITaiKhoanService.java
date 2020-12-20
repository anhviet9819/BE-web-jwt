package com.example.intern.service;

import com.example.intern.model.TaiKhoan;


public interface ITaiKhoanService {
	
//	List<TaiKhoan> queryByUsernameAndSdt(String email, String sdt);
	TaiKhoan getOneById(Long id);
	TaiKhoan save(TaiKhoan taikhoan);
	void delete(Long id);
}
