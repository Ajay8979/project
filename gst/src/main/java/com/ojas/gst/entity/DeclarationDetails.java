package com.ojas.gst.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "declaration_details ")
public class DeclarationDetails implements com.ojas.gst.dao.Entity{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	public String place;
	
	@Temporal(TemporalType.DATE)
	public Date date;
	public String sign;
	public String authorizedsignatorydesignation;
	public String authorizedsignatoryname;
	public Long getId() {
		return id;
	}
	
	public DeclarationDetails(String place, Date date, String sign, String authorizedsignatorydesignation,
			String authorizedsignatoryname) {
		super();
		this.place = place;
		this.date = date;
		this.sign = sign;
		this.authorizedsignatorydesignation = authorizedsignatorydesignation;
		this.authorizedsignatoryname = authorizedsignatoryname;
	}
	
	public DeclarationDetails() {
		super();
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getAuthorizedsignatorydesignation() {
		return authorizedsignatorydesignation;
	}
	public void setAuthorizedsignatorydesignation(String authorizedsignatorydesignation) {
		this.authorizedsignatorydesignation = authorizedsignatorydesignation;
	}
	public String getAuthorizedsignatoryname() {
		return authorizedsignatoryname;
	}
	public void setAuthorizedsignatoryname(String authorizedsignatoryname) {
		this.authorizedsignatoryname = authorizedsignatoryname;
	}
	
//	decdtls.pl	Place	String with 60 char	Chennai
//	decdtls.dt	Date	DD/MM/YYYY format	27/01/2017
//	decdtls.signty	Sign Type	String with 30 char	DSC/e-Sign/EVC
//	decdtls.asdes	Designation	String with 30 char	L1
//	decdtls.asnm	Authorized signatory name	String	ABCDE1234X

}
