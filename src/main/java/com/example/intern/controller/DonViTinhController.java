package com.example.intern.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.intern.exception.DuplicateIdException;
import com.example.intern.model.DonViTinh;
import com.example.intern.service.IDonViTinhService;

@RestController
@RequestMapping("/api/donvitinh")
public class DonViTinhController {
	
	@Autowired
	private IDonViTinhService donvitinhService;

	@GetMapping("/search")
	public List<DonViTinh> queryDonViTinh(@RequestParam(name = "ten", required = false )String ten){
		return donvitinhService.queryByTen(ten);
	}
	
	@GetMapping("/details/{id}")
	public DonViTinh getOneById(@PathVariable("id") Long id) {
		return donvitinhService.getOneById(id);
	}
	
	@PostMapping("/create")
	public DonViTinh createDonViTinh(@Valid @RequestBody DonViTinh donvitinh) {
		if(donvitinh.getId() == null) return donvitinhService.save(donvitinh);
		DonViTinh donvitinh2 = donvitinhService.getOneById(donvitinh.getId());
		if(donvitinh2 != null) throw new DuplicateIdException("BenhNhan", donvitinh.getId());
		
		return donvitinhService.save(donvitinh);
	}
	
	@PutMapping("/update/{id}")
	public DonViTinh updateDonViTinh(@PathVariable("id")Long id,
			@Valid @RequestBody DonViTinh donvitinhRequest) {
		DonViTinh donvitinh = donvitinhService.getOneById(id);
		donvitinh.setTen(donvitinhRequest.getTen());
		donvitinh.setChitiet(donvitinhRequest.getChitiet());
		
		return donvitinhService.save(donvitinh);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteDonViTinh(@PathVariable("id") Long id) {
		donvitinhService.delete(id);
		return ResponseEntity.ok().build();
	}
}



















