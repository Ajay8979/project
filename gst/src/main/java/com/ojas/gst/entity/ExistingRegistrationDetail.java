package com.ojas.gst.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ojas.gst.dao.Entity;

@javax.persistence.Entity
@Table(name = "existing_registration")
public class ExistingRegistrationDetail  implements Entity{	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfRegistration;
	private String Type;
	private String  registrationId;
	private Character isValidatedOrprogress;
	
	public ExistingRegistrationDetail() {}
	
	public ExistingRegistrationDetail(Date dateOfRegistration, String type, String iD,
			Character isValidatedOrprogress) {
		super();
		this.dateOfRegistration = dateOfRegistration;
		this.Type = type;
		this.registrationId = iD;
		this.isValidatedOrprogress = isValidatedOrprogress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}
	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public Character getIsValidatedOrprogress() {
		return isValidatedOrprogress;
	}
	public void setIsValidatedOrprogress(Character isValidatedOrprogress) {
		this.isValidatedOrprogress = isValidatedOrprogress;
	}
}
