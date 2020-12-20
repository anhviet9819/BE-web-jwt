package com.example.intern.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.intern.exception.DuplicateIdException;
import com.example.intern.model.DonThuoc;
import com.example.intern.service.IDonThuocService;

@RestController
@RequestMapping("/api/donthuoc")
public class DonThuocController {
	
	@Autowired
	private IDonThuocService donthuocService;
	
	@GetMapping("/details/{id}")
	public DonThuoc getOneById(@PathVariable("id")Long id) {
		return donthuocService.getOneById(id);
	}
	
	@GetMapping("donthuoc/search")
	public List<DonThuoc> queryByDangKyKhamIdAndTenThuoc(@RequestParam(name = "dangkykhamid", required = false)Long dangkykhamId,
														 @RequestParam(name = "tenthuoc", required = false)Long thuocId){
		return donthuocService.queryByDangKyKhamIdAndTenThuoc(dangkykhamId,thuocId);
	}
	
	@PostMapping("/create")
	public DonThuoc createDonThuoc (@Valid @RequestBody DonThuoc donthuoc) {
		if(donthuoc.getId() == null) return donthuocService.save(donthuoc);
		DonThuoc donthuoc2 = donthuocService.getOneById(donthuoc.getId());
		if(donthuoc2 != null) throw new DuplicateIdException("DonThuoc", donthuoc.getId());
		
		return donthuocService.save(donthuoc);
	}
	
	@PutMapping("/update/{id}")
	public DonThuoc updateDonThuoc (@PathVariable("id")Long id,
			@Valid @RequestBody DonThuoc donthuocRequest) {
		DonThuoc donthuoc = donthuocService.getOneById(id);
		donthuoc.setSoluong(donthuocRequest.getSoluong());
		donthuoc.setHuongdan(donthuocRequest.getHuongdan());
		donthuoc.setDangkykham(donthuocRequest.getDangkykham());
		donthuoc.setDonvitinh(donthuocRequest.getDonvitinh());
		donthuoc.setThuoc(donthuocRequest.getThuoc());
		
		return donthuocService.save(donthuocRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteDonThuoc(@PathVariable("id")Long id) {
		donthuocService.deleteByDangkykhamId(id);
		return ResponseEntity.ok().build();
	}
}
