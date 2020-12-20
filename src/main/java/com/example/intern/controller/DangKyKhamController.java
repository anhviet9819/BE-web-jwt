package com.example.intern.controller;

import java.util.Date;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.intern.exception.DuplicateIdException;
import com.example.intern.model.DangKyKham;
import com.example.intern.service.IDangKyKhamService;

@RestController
@RequestMapping("/api/dangkykham")
public class DangKyKhamController {
	
	@Autowired
	private IDangKyKhamService dangkykhamService;

	@GetMapping("/search")
	public List<DangKyKham> queryQuery(@RequestParam("thoigiandkbegin")
										   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date thoigiandkBegin,
									   @RequestParam("thoigiandkend")
										   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date thoigiandkEnd,
									   @RequestParam("thoigiankhambegin")
										   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date thoigiankhamBegin,
									   @RequestParam("thoigiankhamend")
										   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date thoigiankhamEnd,
									   @RequestParam(name = "trangthaikham", required = false)Boolean trangthaikham,
									   @RequestParam(name = "benhnhanid", required = false)Long benhnhanid,
									   @RequestParam(name = "bacsiid", required = false)Long bacsiid){
		return dangkykhamService.queryQuery(thoigiandkBegin,thoigiandkEnd,thoigiankhamBegin,thoigiankhamEnd,trangthaikham,benhnhanid,bacsiid);
	}


	@GetMapping("/details/{id}")
	public DangKyKham getOneById(@PathVariable("id")Long id) {
		return dangkykhamService.getOneById(id);
	}
  
	@PostMapping("/create")
	public DangKyKham createDangKyKham(@Valid @RequestBody DangKyKham dangkykham) {
		if(dangkykham.getId() == null) return dangkykhamService.save(dangkykham);
		DangKyKham dangkykham2 = dangkykhamService.getOneById(dangkykham.getId());
		if(dangkykham2 != null) throw new DuplicateIdException("DangKyKham", dangkykham.getId());

		return dangkykhamService.save(dangkykham);
	}
	
	@PutMapping("/update/{id}")
	public DangKyKham createDangKyKham(@PathVariable("id")Long id,
			@Valid @RequestBody DangKyKham dangkykhamRequest) {
		DangKyKham dangkykham = dangkykhamService.getOneById(id);
		
		dangkykham.setThoigiandk(dangkykhamRequest.getThoigiandk());
		dangkykham.setThoigiankham(dangkykhamRequest.getThoigiankham());
		dangkykham.setTrangthaikham(dangkykhamRequest.isTrangthaikham());
		dangkykham.setNoidungkham(dangkykhamRequest.getNoidungkham());
		dangkykham.setLoaikham(dangkykhamRequest.getLoaikham());
		dangkykham.setBenhphu(dangkykhamRequest.getBenhphu());
		dangkykham.setMota(dangkykhamRequest.getMota());
		dangkykham.setBacsi(dangkykhamRequest.getBacsi());
		dangkykham.setBenhnhan(dangkykhamRequest.getBenhnhan());
		dangkykham.setBenh(dangkykhamRequest.getBenh());
		
		return dangkykhamService.save(dangkykham);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")Long id) {
		dangkykhamService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}	





























