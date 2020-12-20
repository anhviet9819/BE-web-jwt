package com.example.intern.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.intern.exception.DuplicateIdException;
import com.example.intern.model.Benh;
import com.example.intern.service.IBenhService;

@RestController
@RequestMapping("/api/benh")
public class BenhController {
	
	@Autowired
	private IBenhService benhService;

	@GetMapping("/search")
	public List<Benh> queryTen(@RequestParam(name = "ten", required = false )String ten){
		return benhService.queryByTen(ten);
	}

	@GetMapping("/details/{id}")
	public Benh getOneById(@PathVariable("id") Long id) {
		return benhService.getOneById(id);
	}
	
	@PostMapping("/create")
	public Benh createBenh(@Valid @RequestBody Benh benh) {
		if(benh.getId() == null) return benhService.save(benh);
		Benh benh2 = benhService.getOneById(benh.getId());
		if(benh2 != null) throw new DuplicateIdException("Benh", benh.getId());
		
		return benhService.save(benh);
	}
	
	@PutMapping("/update/{id}")
	public Benh updateBenh (@PathVariable("id")Long id,
			@Valid @RequestBody Benh benhRequest) {
		Benh benh = benhService.getOneById(id);
		benh.setTen(benhRequest.getTen());
		benh.setMabenh(benhRequest.getMabenh());
		benh.setMota(benhRequest.getMota());
		
		return benhService.save(benh);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBenh(@PathVariable("id")Long id) {
		benhService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}


