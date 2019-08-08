package com.ojas.gst.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.ojas.gst.dao.Entity;

@javax.persistence.Entity
@Table(name = "contact_details")
public class ContactDetails implements Entity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Pattern(regexp = "^[0-9]*$")
	private String phoneNumber;
	
	private String phoneSTDCode;
	@Max(value=16)
	
	private Long faxNumber;
	
	private String faxSTDCode;
	
	@Pattern(regexp="^$|[0-9]{10}")
	@NotNull
	private String mobileNumber;
	
	@Email
	@NotBlank
	private String emailId;
	
	public ContactDetails(@Pattern(regexp = "^[0-9]*$") String phoneNumber, String phoneSTDCode,
			@Max(16) Long faxNumber, String faxSTDCode, @Pattern(regexp = "^$|[0-9]{10}") @NotNull String mobileNumber,
			@Email @NotBlank String emailId) {
		super();
		this.phoneNumber = phoneNumber;
		this.phoneSTDCode = phoneSTDCode;
		this.faxNumber = faxNumber;
		this.faxSTDCode = faxSTDCode;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
	}
	public ContactDetails() { }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneSTDCode() {
		return phoneSTDCode;
	}

	public void setPhoneSTDCode(String phoneSTDCode) {
		this.phoneSTDCode = phoneSTDCode;
	}

	public Long getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(Long faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getFaxSTDCode() {
		return faxSTDCode;
	}

	public void setFaxSTDCode(String faxSTDCode) {
		this.faxSTDCode = faxSTDCode;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	
}
