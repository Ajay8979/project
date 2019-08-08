package com.ojas.gst.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "services_supplies")
public class ServicesSuppliedDetails implements com.ojas.gst.dao.Entity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "services_id")
	private Long id;
	
	@Size(min=1,max=30)
	private String descriptionOfServicesSupplied;
	
	@NotNull
	private Integer serviceAccountingCode;
	
	@ManyToOne
	private GoodAndServiceDetails goodAndServiceDetails;
	
	public ServicesSuppliedDetails(@Size(min = 1, max = 30) String descriptionOfServicesSupplied,
			@NotNull Integer serviceAccountingCode, GoodAndServiceDetails goodAndServiceDetails) {
		super();
		this.descriptionOfServicesSupplied = descriptionOfServicesSupplied;
		this.serviceAccountingCode = serviceAccountingCode;
		this.goodAndServiceDetails = goodAndServiceDetails;
	}
	
	public ServicesSuppliedDetails() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescriptionOfServicesSupplied() {
		return descriptionOfServicesSupplied;
	}

	public void setDescriptionOfServicesSupplied(String descriptionOfServicesSupplied) {
		this.descriptionOfServicesSupplied = descriptionOfServicesSupplied;
	}

	public Integer getServiceAccountingCode() {
		return serviceAccountingCode;
	}

	public void setServiceAccountingCode(Integer serviceAccountingCode) {
		this.serviceAccountingCode = serviceAccountingCode;
	}

	public GoodAndServiceDetails getGoodAndServiceDetails() {
		return goodAndServiceDetails;
	}

	public void setGoodAndServiceDetails(GoodAndServiceDetails goodAndServiceDetails) {
		this.goodAndServiceDetails = goodAndServiceDetails;
	}
	
}
