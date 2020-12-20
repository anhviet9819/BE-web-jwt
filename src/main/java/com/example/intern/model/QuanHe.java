package com.example.intern.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "dm_quanhe")
@JsonIgnoreProperties({"id","hibernateLazyInitializer", "handler"})
public class QuanHe implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idchinh", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private BenhNhan benhnhanchinh;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idphu", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private BenhNhan benhnhanphu;
	
	@Column(columnDefinition = "integer default 0")
	private int loaiquanhe;
	
	
	//constructor and getter setter
	public QuanHe() {
		// TODO Auto-generated constructor stub
	}
	
	public QuanHe(BenhNhan benhnhanchinh, BenhNhan benhnhanphu) {
		super();
		this.benhnhanchinh = benhnhanchinh;
		this.benhnhanphu = benhnhanphu;
	}

	public QuanHe(BenhNhan benhnhanchinh, BenhNhan benhnhanphu, int loaiquanhe) {
		super();
		this.benhnhanchinh = benhnhanchinh;
		this.benhnhanphu = benhnhanphu;
		this.loaiquanhe = loaiquanhe;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public BenhNhan getBenhnhanchinh() {
		return benhnhanchinh;
	}


	public void setBenhnhanchinh(BenhNhan benhnhanchinh) {
		this.benhnhanchinh = benhnhanchinh;
	}


	public BenhNhan getBenhnhanphu() {
		return benhnhanphu;
	}


	public void setBenhnhanphu(BenhNhan benhnhanphu) {
		this.benhnhanphu = benhnhanphu;
	}


	public int getLoaiquanhe() {
		return loaiquanhe;
	}


	public void setLoaiquanhe(int loaiquanhe) {
		this.loaiquanhe = loaiquanhe;
	}
	
}
