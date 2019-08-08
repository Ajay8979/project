package com.ojas.gst.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.ojas.gst.dao.Entity;


@javax.persistence.Entity
@Table
public class BankAccountDetails implements Entity{

	@Id
	@Column(name = "bankdetail_id")
	private Long id;
	
	@NotNull
	private Long bankAccountNumber;
	
	@NotBlank
	private String bankAccountType;
	
	@NotBlank
	private String ifscCode;
	
	@NotBlank
	@Size(min=1,max=99)
	private String bankName;
	
	@NotBlank
	@Size(min=1,max=99)
	private String bankAddress;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "documentsDetails")
	private DocumentsDetails documentsDetails;
	
	public BankAccountDetails(@NotNull Long bankAccountNumber, @NotBlank String bankAccountType,
			@NotBlank String ifscCode, @NotBlank @Size(min = 1, max = 99) String bankName,
			@NotBlank @Size(min = 1, max = 99) String bankAddress, DocumentsDetails documentsDetails) {
		super();
		this.bankAccountNumber = bankAccountNumber;
		this.bankAccountType = bankAccountType;
		this.ifscCode = ifscCode;
		this.bankName = bankName;
		this.bankAddress = bankAddress;
		this.documentsDetails = documentsDetails;
	}
	public BankAccountDetails() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(Long bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankAccountType() {
		return bankAccountType;
	}

	public void setBankAccountType(String bankAccountType) {
		this.bankAccountType = bankAccountType;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	public DocumentsDetails getDocumentsDetails() {
		return documentsDetails;
	}

	public void setDocumentsDetails(DocumentsDetails documentsDetails) {
		this.documentsDetails = documentsDetails;
	}
}
