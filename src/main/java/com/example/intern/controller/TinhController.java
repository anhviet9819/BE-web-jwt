package com.example.intern.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.intern.exception.DuplicateIdException;
import com.example.intern.model.Tinh;
import com.example.intern.service.ITinhService; 
  
@RestController
@CrossOrigin("http://localhost:8081")
@RequestMapping("/api/tinh")
public class TinhController {
	
	@Autowired
	private ITinhService service;
	
	@GetMapping("/search")
	public List<Tinh> queryTinh(@RequestParam(name = "ten", required = false )String ten){
		return service.queryByTen(ten);
	}
	
	@GetMapping("/details/{id}")
	public Tinh getTinhById( @PathVariable("id") Long id ) {
		return service.getOneById(id);
	}
	
	@PostMapping("/create")	
	public Tinh createTinh( @Valid @RequestBody Tinh tinh) {
		if(tinh.getId() == null) return service.save(tinh);
		Tinh tinh2 = service.getOneById(tinh.getId());
		if(tinh2 != null) throw new DuplicateIdException("Tinh", tinh.getId());
		return service.save(tinh);
	}
	
	@PutMapping("/update/{id}")
	public Tinh updateTinh(@PathVariable("id") Long id,  
			@Valid @RequestBody Tinh tinhRequest) {
		Tinh tinh = service.getOneById(id);
		tinh.setTen(tinhRequest.getTen());
		
		return service.save(tinh);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteTinh(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
}

