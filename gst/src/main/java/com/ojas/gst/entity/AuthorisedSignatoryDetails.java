package com.ojas.gst.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToOne;

public class AuthorisedSignatoryDetails {

	private String isPrimaryAuthorizedSignatory; 
	
	@OneToOne(cascade = CascadeType.ALL)
	@Column(name = "user_details")
	private PersonalInfo userDetails;

	public String getIsPrimaryAuthorizedSignatory() {
		return isPrimaryAuthorizedSignatory;
	}

	public void setIsPrimaryAuthorizedSignatory(String isPrimaryAuthorizedSignatory) {
		this.isPrimaryAuthorizedSignatory = isPrimaryAuthorizedSignatory;
	}

	public PersonalInfo getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(PersonalInfo userDetails) {
		this.userDetails = userDetails;
	}
}
