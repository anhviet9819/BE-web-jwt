package com.example.intern.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "dm_bacsi")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BacSi implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@NotNull
	@Size(max = 50)
	private String ten;
	
	@NotNull
	@Size(max = 50)
	private String chuyenkhoa;
	
	@Size(max = 50)
	private String trinhdo;
	
	@Size(max = 200)
	private String mota;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "khoaid", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Khoa khoa;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "taikhoanid", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private TaiKhoan taikhoan;
	
	
	//constructor and getter setter
	public BacSi() {
		// TODO Auto-generated constructor stub
	}

	public BacSi(Long id, String ten, String chuyenkhoa, String trinhdo, String mota, Khoa khoa, TaiKhoan taikhoan) {
		super();
		this.id = id;
		this.ten = ten;
		this.chuyenkhoa = chuyenkhoa;
		this.trinhdo = trinhdo;
		this.mota = mota;
		this.khoa = khoa;
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

	public String getChuyenkhoa() {
		return chuyenkhoa;
	}

	public void setChuyenkhoa(String chuyenkhoa) {
		this.chuyenkhoa = chuyenkhoa;
	}

	public String getTrinhdo() {
		return trinhdo;
	}

	public void setTrinhdo(String trinhdo) {
		this.trinhdo = trinhdo;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public Khoa getKhoa() {
		return khoa;
	}

	public void setKhoa(Khoa khoa) {
		this.khoa = khoa;
	}

	public TaiKhoan getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(TaiKhoan taikhoan) {
		this.taikhoan = taikhoan;
	}
	
}
