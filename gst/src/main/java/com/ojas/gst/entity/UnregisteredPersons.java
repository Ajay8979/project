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
public class UnregisteredPersons implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String pos;
	private Double txval;
	private Double iamt;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public Double getTxval() {
		return txval;
	}
	public void setTxval(Double txval) {
		this.txval = txval;
	}
	public Double getIamt() {
		return iamt;
	}
	public void setIamt(Double iamt) {
		this.iamt = iamt;
	}
	
	
}
