package com.ojas.gst.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "taxpayerstype")
public class TaxPayersType implements com.ojas.gst.entity.Entity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "taxpayerstype_id")
	private Long id;

	@Column(name = "taxpayerstype_name",unique=true)
	private String taxpayerstypeName;

	@Column(name = "taxpayerstype_updatedBy")
	private Long lastUpdatedBy;

	@Column(name = "taxpayerstype_status")
	private String status;

	@Column(name = "taxpayerstype_updatedDate")
	@Temporal(TemporalType.DATE)
	private Date updatedDate;
	
	@Column(name = "taxpayerstype_email")
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaxpayerstypeName() {
		return taxpayerstypeName;
	}

	public void setTaxpayerstypeName(String taxpayerstypeName) {
		this.taxpayerstypeName = taxpayerstypeName;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
