package com.ojas.gst.entity;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ojas.gst.enums.NatureOfPossessionOfPremises;
import com.ojas.gst.enums.StateCode;

@Entity
@Table(name = "principal_business")
public class PrincipalBusinessAddress implements com.ojas.gst.dao.Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="principal_business_id")
	private Long id;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Address address;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private ContactDetails contactDetails;

	@NotNull
	@Enumerated(EnumType.STRING)
	private NatureOfPossessionOfPremises natureOfPossession;

	@ElementCollection
	@CollectionTable(name = "nature_of_business_activity", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "natureofBusinessActivity")
	private String[] natureOfBusinessActivity;

	// private String anyotherregistrationsunderGSTinthesameState;

	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private DocumentsDetails documentsDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	public NatureOfPossessionOfPremises getNatureOfPossession() {
		return natureOfPossession;
	}

	public void setNatureOfPossession(NatureOfPossessionOfPremises natureOfPossession) {
		this.natureOfPossession = natureOfPossession;
	}

	public String[] getNatureOfBusinessActivity() {
		return natureOfBusinessActivity;
	}

	public void setNatureOfBusinessActivity(String[] natureOfBusinessActivity) {
		this.natureOfBusinessActivity = natureOfBusinessActivity;
	}

	public DocumentsDetails getDocumentsDetails() {
		return documentsDetails;
	}

	public void setDocumentsDetails(DocumentsDetails documentsDetails) {
		this.documentsDetails = documentsDetails;
	}

	// private String ImporterExporterCode;

	// ppbzdtls.contdtls.tlphno
	// ppbzdtls.contdtls.fxno
	// private String GSTIN if any;

}
