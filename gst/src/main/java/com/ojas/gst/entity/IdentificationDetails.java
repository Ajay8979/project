package com.ojas.gst.entity;

import javax.persistence.CascadeType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ojas.gst.dao.Entity;

@javax.persistence.Entity
@Table(name = "identification_details")
public class IdentificationDetails  implements Entity{	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	private PanDetails panDetails;
	
	private String PassportNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	private UidDetails uidDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private DinDetails dinDetails;
	
	public IdentificationDetails(PanDetails panDetails, String passportNumber, UidDetails uidDetails,
			DinDetails dinDetails) {
		super();
		this.panDetails = panDetails;
		this.PassportNumber = passportNumber;
		this.uidDetails = uidDetails;
		this.dinDetails = dinDetails;
	}
	public IdentificationDetails() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PanDetails getPanDetails() {
		return panDetails;
	}
	public void setPanDetails(PanDetails panDetails) {
		this.panDetails = panDetails;
	}
	public String getPassportNumber() {
		return PassportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		PassportNumber = passportNumber;
	}
	public UidDetails getUidDetails() {
		return uidDetails;
	}
	public void setUidDetails(UidDetails uidDetails) {
		this.uidDetails = uidDetails;
	}
	public DinDetails getDinDetails() {
		return dinDetails;
	}
	public void setDinDetails(DinDetails dinDetails) {
		this.dinDetails = dinDetails;
	}
}
