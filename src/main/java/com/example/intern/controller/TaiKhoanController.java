package com.example.intern.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.intern.exception.DuplicateIdException;
import com.example.intern.model.TaiKhoan;
import com.example.intern.service.ITaiKhoanService;

@RestController
@RequestMapping("/api/taikhoan")
public class TaiKhoanController {
	
	@Autowired
	private ITaiKhoanService taikhoanService;
	
//	@GetMapping("/search")
//	public List<TaiKhoan> queryByUsernameAndSdt(@RequestParam(name = "email",required = false)String email,
//			@RequestParam(name = "sdt", required = false)String sdt){
//		return taikhoanService.queryByUsernameAndSdt(email,sdt);
//	}
	
	@GetMapping("/details/{id}")
	public TaiKhoan getOneById(@PathVariable("id")Long id) {
		return taikhoanService.getOneById(id);
	}

	@PostMapping("/create")
	public TaiKhoan createTaiKhoan(@Valid @RequestBody TaiKhoan taikhoan ) {
		if(taikhoan.getId() == null) return taikhoanService.save(taikhoan);
		TaiKhoan taikhoan2 = taikhoanService.getOneById(taikhoan.getId());
		if(taikhoan2 != null) throw new DuplicateIdException("TaiKhoan", taikhoan.getId());
		
		return taikhoanService.save(taikhoan);
	}

	@PutMapping("/update/{id}")
	public TaiKhoan updateTaiKhoan (@PathVariable("id")Long id,
			@Valid @RequestBody TaiKhoan taikhoanRequest) {
		TaiKhoan taikhoan = taikhoanService.getOneById(id);
		taikhoan.setUsername(taikhoanRequest.getUsername());
		taikhoan.setPassword(taikhoanRequest.getPassword());
		taikhoan.setSdt(taikhoanRequest.getSdt());
		taikhoan.setHoten(taikhoanRequest.getHoten());
		
		return taikhoanService.save(taikhoan);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteTaiKhoan(@PathVariable("id") Long id) {
		taikhoanService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}











