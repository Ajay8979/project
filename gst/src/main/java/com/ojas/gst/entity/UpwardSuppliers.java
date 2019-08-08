package com.ojas.gst.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UpwardSuppliers implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ty;
	private Double inter;
	private Double intra;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTy() {
		return ty;
	}
	public void setTy(String ty) {
		this.ty = ty;
	}
	public Double getInter() {
		return inter;
	}
	public void setInter(Double inter) {
		this.inter = inter;
	}
	public Double getIntra() {
		return intra;
	}
	public void setIntra(Double intra) {
		this.intra = intra;
	}
	
}
