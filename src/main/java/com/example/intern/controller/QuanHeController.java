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

import com.example.intern.service.IBenhNhanService;
import com.example.intern.service.IQuanHeService;
import com.example.intern.exception.DuplicateIdException;
import com.example.intern.model.BenhNhan;
import com.example.intern.model.QuanHe;

@RestController
@RequestMapping("/api/quanhe")
public class QuanHeController {
	
	@Autowired
	private IQuanHeService quanheService;
	
	@Autowired
	private IBenhNhanService benhnhanService;
	
	
	@GetMapping("/search")
	public List<QuanHe> queryByBenhnhanchinhIdAndBenhnhanphuId(@RequestParam(name = "idchinh", required = false)Long benhnhanchinhid ,
			@RequestParam(name = "idphu", required = false)Long benhnhanphuid){
		return quanheService.queryByBenhnhanchinhIdAndBenhnhanphuId(benhnhanchinhid,benhnhanphuid);
	}
	
	@PostMapping("/create")
	public QuanHe createQuanHe(@Valid @RequestBody QuanHe quanheRequest) {
		if(quanheRequest.getId() == null) return quanheService.save(quanheRequest);
		QuanHe quanhe2 = quanheService.getOneById(quanheRequest.getId());
		if(quanhe2 != null) throw new DuplicateIdException("QuanHe", quanheRequest.getId());
		
		return quanheService.save(quanheRequest);
	}
	
	@PutMapping("/update/{id}")
	public QuanHe updateQuanHe(@PathVariable("id")Long id,
			@Valid @RequestBody QuanHe quanheRequest) {
		QuanHe quanhe = quanheService.getOneById(id);
		quanhe.setLoaiquanhe(quanheRequest.getLoaiquanhe());
		quanhe.setBenhnhanchinh(quanheRequest.getBenhnhanchinh());
		quanhe.setBenhnhanphu(quanheRequest.getBenhnhanphu());
		
		return quanheService.save(quanhe);
	}
	
	@DeleteMapping("/{benhnhanchinhid}/{benhnhanphuid}")
	public ResponseEntity<?> deleteQuanHe(@PathVariable("benhnhanchinhid")Long benhnhanchinhid,
			@PathVariable("benhnhanphuid")Long benhnhanphuid) {
		BenhNhan benhnhanchinh = benhnhanService.getOneById(benhnhanchinhid);
		BenhNhan benhnhanphu = benhnhanService.getOneById(benhnhanphuid);
		quanheService.deleleByBenhnhanchinhIdAndBenhnhanphu(benhnhanchinh, benhnhanphu);
		return ResponseEntity.ok().build();
	}
}















