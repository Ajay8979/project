package com.ojas.gst.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ojas.gst.dao.Entity;



@javax.persistence.Entity
@Table()
public class DinDetails implements Entity{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String dinNumberOfTheMember;
	
	private Integer	isValidDIN;
	
	public DinDetails(Long id, String dinNumberOfTheMember, Integer isValidDIN) {
		super();
		this.dinNumberOfTheMember = dinNumberOfTheMember;
		this.isValidDIN = isValidDIN;
	}
	public DinDetails() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDinNumberOfTheMember() {
		return dinNumberOfTheMember;
	}
	public void setDinNumberOfTheMember(String dinNumberOfTheMember) {
		this.dinNumberOfTheMember = dinNumberOfTheMember;
	}
	public Integer getIsValidDIN() {
		return isValidDIN;
	}
	public void setIsValidDIN(Integer isValidDIN) {
		this.isValidDIN = isValidDIN;
	}
}
