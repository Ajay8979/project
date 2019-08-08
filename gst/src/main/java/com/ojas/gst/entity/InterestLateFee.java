package com.ojas.gst.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class InterestLateFee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "intr_details_id")
	private InterestDetails intr_details;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ltfee_details_id")
	private LateFeeDetails ltfee_details;
	
	public InterestDetails getIntr_details() {
		return intr_details;
	}
	public void setIntr_details(InterestDetails intr_details) {
		this.intr_details = intr_details;
	}
	public LateFeeDetails getLtfee_details() {
		return ltfee_details;
	}
	public void setLtfee_details(LateFeeDetails ltfee_details) {
		this.ltfee_details = ltfee_details;
	}
	
	
}
