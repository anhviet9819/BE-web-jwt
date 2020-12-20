package com.example.intern.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class DonThuocPK {
	
	@ManyToOne()
	@JoinColumn(name = "thuocid", nullable = false)
	private Thuoc thuoc;
	
	@ManyToOne()
	@JoinColumn(name = "donvitinh" , nullable = false )
	private DonViTinh donvitinh;
	
	@ManyToOne()
	@JoinColumn(name = "dangkykham" , nullable = false )
	private DangKyKham dangkykham;
	
	
	//constructor and getter setter
	public DonThuocPK() {
		// TODO Auto-generated constructor stub
	}

	public DonThuocPK(int soluong, String huongdan, Thuoc thuoc, DonViTinh donvitinh, DangKyKham dangkykham) {
		super();
		this.thuoc = thuoc;
		this.donvitinh = donvitinh;
		this.dangkykham = dangkykham;
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
	
}
//
//@Embeddable
//public class EntityPropertyPK {
//    @Column(name = "name")
//    private String name;
//
//    @ManyToOne
//    @JoinColumn(name = "entity_id")
//    private Entity entity;
//
//    ...
//}