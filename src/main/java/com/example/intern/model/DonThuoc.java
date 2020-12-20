package com.example.intern.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "kb_donthuoc")
@JsonIgnoreProperties({"id","hibernateLazyInitializer", "handler"})
public class DonThuoc implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull 
	private float soluong;
	
	@Size(max = 100)
	private String huongdan;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "thuocid", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Thuoc thuoc;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "donvitinhid" , nullable = false )
	@OnDelete(action = OnDeleteAction.CASCADE)
	private DonViTinh donvitinh;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "dangkykhamid" , nullable = false )
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnoreProperties({"thoigiandk","thoigiankham","trangthaikham","noidungkham","loaikham","benh","benhphu","mota"})
	private DangKyKham dangkykham;
	
	
	//constructor and getter setter
	public DonThuoc() {
		// TODO Auto-generated constructor stub
	}

	public DonThuoc(Long id, float soluong, String huongdan, Thuoc thuoc, DonViTinh donvitinh, DangKyKham dangkykham) {
		super();
		this.id = id;
		this.soluong = soluong;
		this.huongdan = huongdan;
		this.thuoc = thuoc;
		this.donvitinh = donvitinh;
		this.dangkykham = dangkykham;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Thuoc getThuoc() {
		return thuoc;
	}

	public void setThuoc(Thuoc thuoc) {
		this.thuoc = thuoc;
	}

	public DonViTinh getDonvitinh() {
		return donvitinh;
	}

	public void setDonvitinh(DonViTinh donvitinh) {
		this.donvitinh = donvitinh;
	}

	public DangKyKham getDangkykham() {
		return dangkykham;
	}

	public void setDangkykham(DangKyKham dangkykham) {
		this.dangkykham = dangkykham;
	}

	public float getSoluong() {
		return soluong;
	}

	public void setSoluong(float soluong) {
		this.soluong = soluong;
	}

	public String getHuongdan() {
		return huongdan;
	}

	public void setHuongdan(String huongdan) {
		this.huongdan = huongdan;
	}
	
}
