package com.example.intern.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.intern.exception.DuplicateIdException;
import com.example.intern.model.CoSoYTe;
import com.example.intern.service.ICoSoYTeService;

@RestController
@CrossOrigin("http://localhost:8081")
@RequestMapping("/api/cosoyte")
public class CoSoYTeController {
	
	@Autowired
	public ICoSoYTeService cosoyteService;
	
	
	@GetMapping("/search")
	public List<CoSoYTe> getAll(@RequestParam(name = "ten", required = false)String ten,
			@RequestParam(name = "tinhid", required = false)Long  tinhid){
		return cosoyteService.queryByTenAndTinh(ten, tinhid);
	}
	
	@GetMapping("/details/{id}")
	public CoSoYTe getOneById(@PathVariable("id") Long id  ) {
		return cosoyteService.getOneById(id);
	}
	
	@PostMapping("/create")
	public CoSoYTe createCoSoYTe(@Valid @RequestBody CoSoYTe cosoyte) {
		if(cosoyte.getId() == null) return cosoyteService.save(cosoyte);
		CoSoYTe cosoyte2 = cosoyteService.getOneById(cosoyte.getId());
		if(cosoyte2 != null) throw new DuplicateIdException("CoSoYTe", cosoyte.getId());
		
		return cosoyteService.save(cosoyte);
	}
	
	
	@PutMapping("/update/{id}")
	public CoSoYTe updateCoSoYTeByTinhId(@PathVariable("id") Long id,
			@Valid @RequestBody CoSoYTe cosoyte ) {
		CoSoYTe cs = cosoyteService.getOneById(id);
		cs.setTen(cosoyte.getTen());
		cs.setTinh(cosoyte.getTinh());
		
		return cosoyteService.save(cs);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		cosoyteService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
