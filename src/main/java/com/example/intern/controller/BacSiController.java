package com.example.intern.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.intern.model.BacSi;
import com.example.intern.service.IBacSiService;

@RestController
@CrossOrigin("http://localhost:8081")
@RequestMapping("/api/bacsi")
public class BacSiController {
	
	@Autowired 
	private IBacSiService bacsiService;
	
	
	@GetMapping("/search")
	public List<BacSi> queryByTenAndTrinhdoAndKhoaId(@RequestParam(name = "ten", required = false)String ten ,
			@RequestParam (name = "trinhdo", required = false)String trinhdo,
			@RequestParam(name = "khoaid", required = false)Long khoaid){
		return bacsiService.queryByTenAndTrinhdoAndKhoaId(ten,trinhdo,khoaid);
	}
	
	@GetMapping("/details/{id}")
	public BacSi getOneById(@PathVariable("id") Long id) {
		return bacsiService.getOneById(id);
	}
	
	@PostMapping("/create")
	public BacSi createBacSi(@Valid @RequestBody BacSi bacsi) {
		return bacsiService.save(bacsi);
	}
	
	@PutMapping("/update/{id}")
	public BacSi updateBacSiByKhoaId(@PathVariable("id") Long id,
			@Valid @RequestBody BacSi bacsiRequest) {
		BacSi bacsi = bacsiService.getOneById(id);
		
		bacsi.setTen(bacsiRequest.getTen());
		bacsi.setChuyenkhoa(bacsiRequest.getChuyenkhoa());
		bacsi.setTrinhdo(bacsiRequest.getTrinhdo());
		bacsi.setMota(bacsiRequest.getMota());
		bacsi.setKhoa(bacsiRequest.getKhoa());
		
		return bacsiService.save(bacsi);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBacSi(@PathVariable("id") Long id) {
		bacsiService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}



























