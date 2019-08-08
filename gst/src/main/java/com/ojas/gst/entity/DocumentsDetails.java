package com.ojas.gst.entity;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ojas.gst.dao.Entity;

@javax.persistence.Entity
@Table(name = "document_details")
public class DocumentsDetails implements Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "document_id")
	private Long id;

	private String contentType;
	private String documentType;
	private String documentHash;

	@ManyToOne
	private BusinessDetails businessDetails;
	
	@ManyToOne
	private PersonalInfo personalInfo;

	public DocumentsDetails(String contentType, String documentType, String documentHash) {
		super();
		this.contentType = contentType;
		this.documentType = documentType;
		this.documentHash = documentHash;
	}

	public DocumentsDetails() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocumentHash() {
		return documentHash;
	}

	public void setDocumentHash(String documentHash) {
		this.documentHash = documentHash;
	}

}
