package com.ojas.gst.entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.ojas.gst.dao.Entity;

@javax.persistence.Entity
@Table(name = "jurisdiction_details")
public class JurisdictionDetails implements Entity{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String StateJurisdiction;
	
	private String WardOrCircleOrSectorNo;
	
	@Size(min=1,max=15)
	private String CenterJurisdiction;
	
	private String rangeCode;
	
	private String commisionarateCode;
	
	private String divisionCode;
	
	public JurisdictionDetails() {}
	
	public JurisdictionDetails(String stateJurisdiction,
			 String wardOrCircleOrSectorNo, @Size(min = 1, max = 15) String centerJurisdiction,
			 String rangeCode,String commisionarateCode, String divisionCode) {
		super();
		this.StateJurisdiction = stateJurisdiction;
		this.WardOrCircleOrSectorNo = wardOrCircleOrSectorNo;
		this.CenterJurisdiction = centerJurisdiction;
		this.rangeCode = rangeCode;
		this.commisionarateCode = commisionarateCode;
		this.divisionCode = divisionCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStateJurisdiction() {
		return StateJurisdiction;
	}

	public void setStateJurisdiction(String stateJurisdiction) {
		StateJurisdiction = stateJurisdiction;
	}

	public String getWardOrCircleOrSectorNo() {
		return WardOrCircleOrSectorNo;
	}

	public void setWardOrCircleOrSectorNo(String wardOrCircleOrSectorNo) {
		WardOrCircleOrSectorNo = wardOrCircleOrSectorNo;
	}

	public String getCenterJurisdiction() {
		return CenterJurisdiction;
	}

	public void setCenterJurisdiction(String centerJurisdiction) {
		CenterJurisdiction = centerJurisdiction;
	}

	public String getRangeCode() {
		return rangeCode;
	}

	public void setRangeCode(String rangeCode) {
		this.rangeCode = rangeCode;
	}

	public String getCommisionarateCode() {
		return commisionarateCode;
	}

	public void setCommisionarateCode(String commisionarateCode) {
		this.commisionarateCode = commisionarateCode;
	}

	public String getDivisionCode() {
		return divisionCode;
	}

	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}
}
