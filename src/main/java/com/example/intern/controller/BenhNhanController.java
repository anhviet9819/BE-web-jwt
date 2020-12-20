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
import com.example.intern.model.BenhNhan;
import com.example.intern.model.QuanHe;
import com.example.intern.service.IBenhNhanService;
import com.example.intern.service.IQuanHeService;

@RestController
@RequestMapping("/api/benhnhan")
public class BenhNhanController {
	
	@Autowired
	private IBenhNhanService benhnhanService;
	
	@Autowired
	private IQuanHeService quanheService;
	
	@GetMapping("/search")
	public List<BenhNhan> getAll(@RequestParam(name = "ten", required = false)String ten,
			@RequestParam(name = "gioitinh",required = false)Boolean gioitinh,
			@RequestParam(name = "diachi",required = false)String diachi){
		return benhnhanService.queryByTenAndNgaysinhAndDiachi(ten,gioitinh,diachi);
	}
	
	@GetMapping("/details/{id}")
	public BenhNhan getOneById(@PathVariable("id") Long id) {
		return benhnhanService.getOneById(id);
	}
	
	
	
	@PostMapping("/create")
	public BenhNhan createBenhNhan(@Valid @RequestBody BenhNhan benhnhan) {
		if(benhnhan.getId() == null) return benhnhanService.save(benhnhan);
		BenhNhan benhnhan2 = benhnhanService.getOneById(benhnhan.getId());
		if(benhnhan2 != null) throw new DuplicateIdException("BenhNhan", benhnhan.getId());
		QuanHe quanhe = new QuanHe( benhnhan, benhnhan ); 
		quanheService.save(quanhe);
		
		return benhnhanService.save(benhnhan);
	}
	
	
	@PutMapping("/update/{id}")
	public BenhNhan updateBenhNhan(@PathVariable("id")Long id,
			@Valid @RequestBody BenhNhan benhnhanRequest) {
		BenhNhan benhnhan = benhnhanService.getOneById(id);
		
		benhnhan.setTen(benhnhanRequest.getTen());
		benhnhan.setNgaysinh(benhnhanRequest.getNgaysinh());
		benhnhan.setGioitinh(benhnhanRequest.getGioitinh());
		benhnhan.setCmnd(benhnhanRequest.getCmnd());
		benhnhan.setNgaycap(benhnhanRequest.getNgaycap());
		benhnhan.setNoicap(benhnhanRequest.getNoicap());
		benhnhan.setBhyt(benhnhanRequest.getBhyt());
		benhnhan.setDiachi(benhnhanRequest.getDiachi());
		
		return benhnhanService.save(benhnhan);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBenhNhan(@PathVariable("id") Long id) {
		benhnhanService.delete(id);
		return ResponseEntity.ok().build();
	}
}


