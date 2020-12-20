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
import com.example.intern.model.Khoa;
import com.example.intern.service.IKhoaService;

@RestController
@RequestMapping("/api/khoa")
public class KhoaController {
	
	@Autowired
	private IKhoaService khoaService;
	
	
	@GetMapping("/search")
	public List<Khoa> queryByTenAndCosoyteId(@RequestParam(name = "ten", required = false )String ten,
			@RequestParam(name = "cosoyteid", required = false)Long cosoyteid){
		return khoaService.queryByTenAndCosoyteId(ten,cosoyteid);
	}
	
	@GetMapping("/details/{id}")
	public Khoa getOneById(@PathVariable("id") Long id) {
		return khoaService.getOneById(id);
	}
	
	@PostMapping("/create")
	public Khoa createKhoa(@PathVariable Long id,
			@Valid @RequestBody Khoa khoa) {
		if(khoa.getId() == null) return khoaService.save(khoa);
		Khoa khoa2 = khoaService.getOneById(khoa.getId());
		if(khoa2 != null) throw new DuplicateIdException("Khoa", khoa.getId());
		
		return khoaService.save(khoa);
	}
	
	@PutMapping("/update/{id}")
	public Khoa updateKhoa(@PathVariable("id") Long id,
			@Valid @RequestBody Khoa khoaRequest){
		Khoa khoa = khoaService.getOneById(id);
		khoa.setTen(khoaRequest.getTen());
		khoa.setCosoyte(khoaRequest.getCosoyte());
		
		return khoaService.save(khoa);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteKhoa(@PathVariable("id") Long id) {
		khoaService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
















