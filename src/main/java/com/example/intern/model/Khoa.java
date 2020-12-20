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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "dm_khoa")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Khoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@NotNull
	@Size(max = 50)
	private String ten;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cosoyteid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CoSoYTe cosoyte;
	
	
	//constructor and getter setter
	public Khoa() {
		
	}
	public Khoa(Long id, String ten, CoSoYTe cosoyte) {
		super();
		this.id = id;
		this.ten = ten;
		this.cosoyte = cosoyte;
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
	public CoSoYTe getCosoyte() {
		return cosoyte;
	}
	public void setCosoyte(CoSoYTe cosoyte) {
		this.cosoyte = cosoyte;
	}
	
	
	
}
