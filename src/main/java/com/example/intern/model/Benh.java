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
@Table(name = "dm_benh")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Benh implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 100)
	private String ten;
	
	@Size(max = 20)
	private String mabenh;
	
	@NotNull
	@Size(max = 500)
	private String mota;
	
	
	//constructor and getter setter
	public Benh() {
		// TODO Auto-generated constructor stub
	}
	
	public Benh(Long id, String ten, String mabenh, String mota) {
		super();
		this.id = id;
		this.ten = ten;
		this.mabenh = mabenh;
		this.mota = mota;
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

	public String getMabenh() {
		return mabenh;
	}

	public void setMabenh(String mabenh) {
		this.mabenh = mabenh;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}
}
