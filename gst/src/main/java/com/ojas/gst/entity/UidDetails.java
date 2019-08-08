package com.ojas.gst.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ojas.gst.dao.Entity;

@javax.persistence.Entity
public class UidDetails implements Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String uidNumber;
	private Character isValidUID;
	private String declarationOfAadhar;
	
	public UidDetails( String uidNumber, Character isValidUID, String declarationOfAadhar) {
		super();
		this.uidNumber = uidNumber;
		this.isValidUID = isValidUID;
		this.declarationOfAadhar = declarationOfAadhar;
	}
	
	public UidDetails() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUidNumber() {
		return uidNumber;
	}
	public void setUidNumber(String uidNumber) {
		this.uidNumber = uidNumber;
	}
	public Character getIsValidUID() {
		return isValidUID;
	}
	public void setIsValidUID(Character isValidUID) {
		this.isValidUID = isValidUID;
	}
	public String getDeclarationOfAadhar() {
		return declarationOfAadhar;
	}
	public void setDeclarationOfAadhar(String declarationOfAadhar) {
		this.declarationOfAadhar = declarationOfAadhar;
	}	
}
