package com.ojas.gst.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

import com.ojas.gst.dao.Entity;
import com.ojas.gst.enums.Gender;

@javax.persistence.Entity
@Table(name = "personal_info")
public class PersonalInfo implements com.ojas.gst.entity.Entity{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstname;
	
	private String middlename;
	
	private String	lastname;
	@Column(name = "father_husaband_firstname")
	private String fatherorhusabandfirstname;
	
	@Column(name = "father_husaband_middlename")
	private String fatherorhusabandmiddlename;
	
	@Column(name = "father_husaband_lastname")
	private String fatherorhusabandlastname;
	
	private String designation;
	
	//private Integer entityid;
	
	@Temporal(TemporalType.DATE)
	private Date dateofbirth;
	
	private Boolean isCitizeOfIndia = true;
	
	@Pattern(regexp="(^$|[0-9]{10})")
	private String	mobilenumber;
	
	@Email()
	private String emailId;
	
	private  Gender gender;
	
	private Integer telephonNumber;
	
	private Integer stdCode;
	
	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	private IdentificationDetails identificationDetails;
	
	@NotNull
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "addr_id")
	private List<Address> address = new ArrayList<Address>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "document_id")
	private List<DocumentsDetails> documentsDetails = new ArrayList<DocumentsDetails>();
	
	/*
	 * public PersonalInfo(@NotBlank @Size(min = 1, max = 99) String firstname,
	 * 
	 * @Size(min = 1, max = 99) String middlename, @Size(min = 1, max = 99) String
	 * lastname,
	 * 
	 * @NotBlank @Size(min = 1, max = 99) String fatherorhusabandfirstname,
	 * 
	 * @Size(min = 1, max = 99) String fatherorhusabandmiddlename,
	 * 
	 * @Size(min = 1, max = 99) String fatherorhusabandlastname,
	 * 
	 * @NotBlank @Size(min = 1, max = 30) String designation, @NotNull Date
	 * dateofbirth, Boolean isCitizeOfIndia,
	 * 
	 * @NotNull @Pattern(regexp = "(^$|[0-9]{10})") String mobilenumber, @Email
	 * String emailI, Gender gender, Integer telephonNumber, Integer
	 * stdCode, @NotNull IdentificationDetails identificationDetails,
	 * 
	 * @NotNull List<Address> address, List<DocumentsDetails> documentsDetails,
	 * Boolean isAuthorisedSignatory) { super(); this.firstname = firstname;
	 * this.middlename = middlename; this.lastname = lastname;
	 * this.fatherorhusabandfirstname = fatherorhusabandfirstname;
	 * this.fatherorhusabandmiddlename = fatherorhusabandmiddlename;
	 * this.fatherorhusabandlastname = fatherorhusabandlastname; this.designation =
	 * designation; this.dateofbirth = dateofbirth; this.isCitizeOfIndia =
	 * isCitizeOfIndia; this.mobilenumber = mobilenumber; this.emailId = emailI;
	 * this.gender = gender; this.telephonNumber = telephonNumber; this.stdCode =
	 * stdCode; this.identificationDetails = identificationDetails; this.address =
	 * address; this.documentsDetails = documentsDetails; this.isAuthorisedSignatory
	 * = isAuthorisedSignatory; }
	 */

	public PersonalInfo(){}
	
	private Boolean isAuthorisedSignatory;

	public Boolean getIsAuthorisedSignatory() {
		return isAuthorisedSignatory;
	}

	public void setIsAuthorisedSignatory(Boolean isAuthorisedSignatory) {
		this.isAuthorisedSignatory = isAuthorisedSignatory;
	}

	public IdentificationDetails getIdentificationDetails() {
		return identificationDetails;
	}

	public void setIdentificationDetails(IdentificationDetails identificationDetails) {
		this.identificationDetails = identificationDetails;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<DocumentsDetails> getDocumentsDetails() {
		return documentsDetails;
	}

	public void setDocumentsDetails(List<DocumentsDetails> documentsDetails) {
		this.documentsDetails = documentsDetails;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFatherorhusabandfirstname() {
		return fatherorhusabandfirstname;
	}

	public void setFatherorhusabandfirstname(String fatherorhusabandfirstname) {
		this.fatherorhusabandfirstname = fatherorhusabandfirstname;
	}

	public String getFatherorhusabandmiddlename() {
		return fatherorhusabandmiddlename;
	}

	public void setFatherorhusabandmiddlename(String fatherorhusabandmiddlename) {
		this.fatherorhusabandmiddlename = fatherorhusabandmiddlename;
	}

	public String getFatherorhusabandlastname() {
		return fatherorhusabandlastname;
	}

	public void setFatherorhusabandlastname(String fatherorhusabandlastname) {
		this.fatherorhusabandlastname = fatherorhusabandlastname;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public Boolean getIsCitizeOfIndia() {
		return isCitizeOfIndia;
	}

	public void setIsCitizeOfIndia(Boolean isCitizeOfIndia) {
		this.isCitizeOfIndia = isCitizeOfIndia;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailI) {
		this.emailId = emailI;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Integer getTelephonNumber() {
		return telephonNumber;
	}

	public void setTelephonNumber(Integer telephonNumber) {
		this.telephonNumber = telephonNumber;
	}

	public Integer getStdCode() {
		return stdCode;
	}

	public void setStdCode(Integer stdCode) {
		this.stdCode = stdCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
