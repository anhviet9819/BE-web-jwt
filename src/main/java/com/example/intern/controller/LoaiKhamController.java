package com.example.intern.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.intern.exception.DuplicateIdException;
import com.example.intern.model.LoaiKham;
import com.example.intern.service.ILoaiKhamService;

@RestController
@RequestMapping("/api/loaikham")
public class LoaiKhamController {

	@Autowired
	private ILoaiKhamService service;
	
	@GetMapping("/search")
	public List<LoaiKham> queryLoaiKham(@RequestParam(name = "ten", required = false )String ten){
		return service.queryByTen(ten);
	}
	
	@GetMapping("/details/{id}")
	public LoaiKham getLoaiKhamById( @PathVariable("id") Long id ) {
		return service.getOneById(id);
	}
	
	@PostMapping("/create")	
	public LoaiKham createLoaiKham( @Valid @RequestBody LoaiKham loaikham) {
		if(loaikham.getId() == null) return service.save(loaikham);
		LoaiKham loaikham2 = service.getOneById(loaikham.getId());
		if(loaikham2 != null) throw new DuplicateIdException("LoaiKham", loaikham.getId());
		return service.save(loaikham);
	}
	
	@PutMapping("/update/{id}")
	public LoaiKham updateLoaiKham(@PathVariable("id") Long id,  
			@Valid @RequestBody LoaiKham loaikhamRequest) {
		LoaiKham loaikham = service.getOneById(id);
		loaikham.setTen(loaikhamRequest.getTen());
		
		return service.save(loaikham);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteLoaiKham(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
