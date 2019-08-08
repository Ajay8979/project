package com.ojas.gst.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name = "drawing_and_disbursing_officer")
public class DrawingAndDisbursingOfficer implements com.ojas.gst.dao.Entity {

	@Id
	@GeneratedValue()
	private Long id;

	// userdetails
	@OneToOne
	private PersonalInfo userDetails;

	// identification details
	@OneToOne
	private IdentificationDetails identificationDetails;
	// ddoResidentialAddress
	@OneToOne
	private Address address;

	// ddoDocumentDetails
	@OneToOne
	private DocumentsDetails documentsDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PersonalInfo getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(PersonalInfo userDetails) {
		this.userDetails = userDetails;
	}

	public IdentificationDetails getIdentificationDetails() {
		return identificationDetails;
	}

	public void setIdentificationDetails(IdentificationDetails identificationDetails) {
		this.identificationDetails = identificationDetails;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public DocumentsDetails getDocumentsDetails() {
		return documentsDetails;
	}

	public void setDocumentsDetails(DocumentsDetails documentsDetails) {
		this.documentsDetails = documentsDetails;
	}
}
