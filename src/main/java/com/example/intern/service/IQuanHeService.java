package com.example.intern.service;

import java.util.List;

import com.example.intern.model.BenhNhan;
import com.example.intern.model.QuanHe;

public interface IQuanHeService {
	List<QuanHe> queryByBenhnhanchinhIdAndBenhnhanphuId(Long benhnhanchinhid,Long benhnhanphuid);
	QuanHe getOneById(Long id);
	QuanHe save(QuanHe quanhe);
	void deleleByBenhnhanchinhIdAndBenhnhanphu(BenhNhan benhnhanchinh, BenhNhan benhnhanphu);
}
