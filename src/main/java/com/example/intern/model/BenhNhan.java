	package com.example.intern.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "dm_benhnhan")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BenhNhan implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@NotNull
	@Size(max = 50)
	private String ten ;
	
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@NotNull
	private Date ngaysinh;
	
	@NotNull
	private Boolean gioitinh;
	
	@Size(max = 20)
	private String cmnd;
	
	private Date ngaycap;
	
	@Size(max = 20)
	private String noicap;
	
	@Size(max = 20)
	private String bhyt;
	
	@NotNull
	@Size(max = 500)
	private String diachi;

	@NotNull
	@Size(max = 300)
	private String anhdaidien;

	@Size(max = 300)
	private String anhbhyt;

	@Size(max = 300)
	private String cmtnd_truoc;

	@Size(max = 300)
	private String cmtnd_sau;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "taikhoanid", nullable = true )
	@OnDelete(action = OnDeleteAction.CASCADE)
	private TaiKhoan taikhoan;
	
	
	//constructor and getter setter
	public BenhNhan() {
		// TODO Auto-generated constructor stub
	}

	public BenhNhan(Long id, String ten, Date ngaysinh, Boolean gioitinh, String cmnd, Date ngaycap, String noicap,
			String bhyt, String diachi, TaiKhoan taikhoan) {
		super();
		this.id = id;
		this.ten = ten;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.cmnd = cmnd;
		this.ngaycap = ngaycap;
		this.noicap = noicap;
		this.bhyt = bhyt;
		this.diachi = diachi;
		this.taikhoan = taikhoan;
	}

	public BenhNhan(Long id, String ten, Date ngaysinh, Boolean gioitinh, String cmnd, Date ngaycap, String noicap, String bhyt, String diachi, String anhdaidien, String anhbhyt, String cmtnd_truoc, String cmtnd_sau, TaiKhoan taikhoan) {
		this.id = id;
		this.ten = ten;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.cmnd = cmnd;
		this.ngaycap = ngaycap;
		this.noicap = noicap;
		this.bhyt = bhyt;
		this.diachi = diachi;
		this.anhdaidien = anhdaidien;
		this.anhbhyt = anhbhyt;
		this.cmtnd_truoc = cmtnd_truoc;
		this.cmtnd_sau = cmtnd_sau;
		this.taikhoan = taikhoan;
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

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public Boolean getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(Boolean gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public Date getNgaycap() {
		return ngaycap;
	}

	public void setNgaycap(Date ngaycap) {
		this.ngaycap = ngaycap;
	}

	public String getNoicap() {
		return noicap;
	}

	public void setNoicap(String noicap) {
		this.noicap = noicap;
	}

	public String getBhyt() {
		return bhyt;
	}

	public void setBhyt(String bhyt) {
		this.bhyt = bhyt;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public TaiKhoan getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(TaiKhoan taikhoan) {
		this.taikhoan = taikhoan;
	}

	public String getAnhdaidien() {
		return anhdaidien;
	}

	public void setAnhdaidien(String anhdaidien) {
		this.anhdaidien = anhdaidien;
	}

	public String getAnhbhyt() {
		return anhbhyt;
	}

	public void setAnhbhyt(String anhbhyt) {
		this.anhbhyt = anhbhyt;
	}

	public String getCmtnd_truoc() {
		return cmtnd_truoc;
	}

	public void setCmtnd_truoc(String cmtnd_truoc) {
		this.cmtnd_truoc = cmtnd_truoc;
	}

	public String getCmtnd_sau() {
		return cmtnd_sau;
	}

	public void setCmtnd_sau(String cmtnd_sau) {
		this.cmtnd_sau = cmtnd_sau;
	}
}
