package com.example.intern.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "dm_donvitinh")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DonViTinh implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 20)
	private String ten;
	
	@Size(max = 100)
	private String chitiet;
	
	
	//constructor and getter setter
	public DonViTinh() {
		// TODO Auto-generated constructor stub
	}

	public DonViTinh(Long id, String ten, String chitiet) {
		super();
		this.id = id;
		this.ten = ten;
		this.chitiet = chitiet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getChitiet() {
		return chitiet;
	}

	public void setChitiet(String chitiet) {
		this.chitiet = chitiet;
	}
	
}
