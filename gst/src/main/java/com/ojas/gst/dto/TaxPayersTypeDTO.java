package com.ojas.gst.dto;

import java.util.Date;

public class TaxPayersTypeDTO {
	
	private Long id;
	private String taxPayersType;
	private Long lastUpdatedBy;
	private Date updatedDate;
	private String status;
	private String email;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTaxPayersType() {
		return taxPayersType;
	}
	public void setTaxPayersType(String taxPayersType) {
		this.taxPayersType = taxPayersType;
	}
	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
	

}
