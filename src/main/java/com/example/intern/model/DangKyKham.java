package com.example.intern.model;

import java.io.Serializable;
import java.util.Date;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "kb_dangkykham")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DangKyKham implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Date thoigiandk;
	
	@NotNull
	private Date thoigiankham;
	
	@NotNull
	private Boolean trangthaikham;
	
	@Size(max = 500)
	private String noidungkham;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false )
	@JoinColumn(name = "loaikhamid", nullable= false )
	@OnDelete(action = OnDeleteAction.CASCADE)
	private LoaiKham loaikham;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false )
	@JoinColumn(name = "benhchinhid", nullable= true )
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Benh benh;
	
	@Size(max = 500)
	private String benhphu;
	
	@Size(max = 500)
	private String mota;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false )
	@JoinColumn(name = "benhnhanid", nullable= false )
	@OnDelete(action = OnDeleteAction.CASCADE)
	private BenhNhan benhnhan;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false )
	@JoinColumn(name = "bacsiid", nullable = false )
	@OnDelete(action = OnDeleteAction.CASCADE)
	private BacSi bacsi;
	
	
	//constructor and getter setter
	public DangKyKham() {
		// TODO Auto-generated constructor stub
	}

	public DangKyKham(Long id, Date thoigiandk, Date thoigiankham, boolean trangthaikham, String noidungkham,
			LoaiKham loaikham, Benh benh, String benhphu, String mota, BenhNhan benhnhan, BacSi bacsi) {
		super();
		this.id = id;
		this.thoigiandk = thoigiandk;
		this.thoigiankham = thoigiankham;
		this.trangthaikham = trangthaikham;
		this.noidungkham = noidungkham;
		this.loaikham = loaikham;
		this.benh = benh;
		this.benhphu = benhphu;
		this.mota = mota;
		this.benhnhan = benhnhan;
		this.bacsi = bacsi;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getThoigiandk() {
		return thoigiandk;
	}

	public void setThoigiandk(Date thoigiandk) {
		this.thoigiandk = thoigiandk;
	}

	public Date getThoigiankham() {
		return thoigiankham;
	}

	public void setThoigiankham(Date thoigiankham) {
		this.thoigiankham = thoigiankham;
	}

	public boolean isTrangthaikham() {
		return trangthaikham;
	}

	public void setTrangthaikham(boolean trangthaikham) {
		this.trangthaikham = trangthaikham;
	}

	public String getNoidungkham() {
		return noidungkham;
	}

	public void setNoidungkham(String noidungkham) {
		this.noidungkham = noidungkham;
	}

	public LoaiKham getLoaikham() {
		return loaikham;
	}

	public void setLoaikham(LoaiKham loaikham) {
		this.loaikham = loaikham;
	}

	public Benh getBenh() {
		return benh;
	}

	public void setBenh(Benh benh) {
		this.benh = benh;
	}

	public String getBenhphu() {
		return benhphu;
	}

	public void setBenhphu(String benhphu) {
		this.benhphu = benhphu;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public BenhNhan getBenhnhan() {
		return benhnhan;
	}

	public void setBenhnhan(BenhNhan benhnhan) {
		this.benhnhan = benhnhan;
	}

	public BacSi getBacsi() {
		return bacsi;
	}

	public void setBacsi(BacSi bacsi) {
		this.bacsi = bacsi;
	}
	
}














