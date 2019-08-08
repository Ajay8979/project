package com.ojas.gst.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registration_details")
public class RegistrationDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String district;
	private String applicationStatus;
	private Integer mobilenumber;
	private String email;
	private String applicationType;
	private String stateCode;
	private String panOrtan;
	private String legalNameofTaxDeductor;
	
	public RegistrationDetails(String district, String applicationStatus, Integer mobilenumber, String email,
			String applicationType, String stateCode, String panOrtan, String legalNameofTaxDeductor) {
		super();
		this.district = district;
		this.applicationStatus = applicationStatus;
		this.mobilenumber = mobilenumber;
		this.email = email;
		this.applicationType = applicationType;
		this.stateCode = stateCode;
		this.panOrtan = panOrtan;
		this.legalNameofTaxDeductor = legalNameofTaxDeductor;
	}
	public RegistrationDetails() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	public Integer getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(Integer mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getApplicationType() {
		return applicationType;
	}
	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getPanOrtan() {
		return panOrtan;
	}
	public void setPanOrtan(String panOrtan) {
		this.panOrtan = panOrtan;
	}
	public String getLegalNameofTaxDeductor() {
		return legalNameofTaxDeductor;
	}
	public void setLegalNameofTaxDeductor(String legalNameofTaxDeductor) {
		this.legalNameofTaxDeductor = legalNameofTaxDeductor;
	}	
//	private String					Pan Number(if pt is 'P')/TAN Number(if pt is 'T')
	

//	rgdtls.moddt						Not relevant for API user
//	rgdtls.duedt						Not relevant for API user
	
}
