package com.ojas.gst.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotBlank;

import com.ojas.gst.dao.Entity;

@javax.persistence.Entity
@Table(name = "pan_details",uniqueConstraints = @UniqueConstraint(columnNames = {
        "panNumber"
    }))
public class PanDetails implements Entity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@NotBlank
	@Column
	private String panNumber;
	private Character isValidPan;
	
	public PanDetails(@NotBlank String panNumber, Character isValidPan) {
		super();
		this.panNumber = panNumber;
		this.isValidPan = isValidPan;
	}
	
	public PanDetails() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public Character getIsValidPan() {
		return isValidPan;
	}
	public void setIsValidPan(Character isValidPan) {
		this.isValidPan = isValidPan;
	}
	
	
}
