package com.ojas.gst.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.ojas.gst.enums.StateCode;

@javax.persistence.Entity
@Table(name = "Gst_business_details")
public class BusinessDetails implements Entity{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private PanDetails panDetails;
	
	@Size(min = 1, max = 99)
	private String legalNameOfBusiness;

	@Size(min = 1, max = 99)
	private String tradeName;

	@Size(min = 1, max = 3)
	private String constitutionOfBusiness;

	@Enumerated(EnumType.ORDINAL)
	private StateCode stateCode;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private JurisdictionDetails jurisdiction;

	@NotNull
	private Character OptedForComposition = 'N';
	// related data with OptedForComposition, if Y
//	bzdtls.bzdtlsbz.isopcmp	Opted in for Composition 	Either ‘Y’ or ‘N’	 Y
//	bzdtls.bzdtlsbz.iscmpdecl	If opt for Comp is Y then declaration of Composition	Either ‘Y’ or ‘N’	Y
//	bzdtls.bzdtlsbz.antoamt	All-India annual turnover declaration amount	Numeric	11
//	bzdtls.bzdtlsbz.cmbzdt	Date of commencement of business	DD/MM/YYYY format	27/01/2017
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dateOfCommencementOfBusiness;

	@NotNull
	private Character areYouCasualDealer = 'N';
	// related data with areYouCasualDealer, if Y
//	bzdtls.bzdtlsbz.iscasdl	Are you Casual Dealer	Either ‘Y’ or ‘N’	Y
//	bzdtls.bzdtlsbz.otherRsLib	Other Reason for liablility	String	liability reason
//	bzdtls.bzdtlsbz.estcgstamt	Estimated Tax Liability (CGST)	decimal(10,2)	1000000
//	bzdtls.bzdtlsbz.estsgstamt	Estimated Tax Liability (SGST)	decimal(10,2)	500000
//	bzdtls.bzdtlsbz.estigstamt	Estimated Tax Liability (IGST)	decimal(10,2)	500000
//	bzdtls.bzdtlsbz.estcessamt	Estimated CESS amount	decimal(10,2)	500000
//	bzdtls.bzdtlsbz.sgsttuovamt	SGST turnover amount	decimal(10,2)	500000
//	bzdtls.bzdtlsbz.cesstuovamt	CESS turnover amount	decimal(10,2)	500000
//	bzdtls.bzdtlsbz.cgsttuovamt	CGST turnover amount	decimal(10,2)	500000
//	bzdtls.bzdtlsbz.igsttuovamt	IGST turnover amount	decimal(10,2)	500000
//	bzdtls.bzdtlsbz.rgfmdt	Start date from which registration is required	DD/MM/YYYY format	27/01/2017
//	bzdtls.bzdtlsbz.rgtodt	End date for registration period	DD/MM/YYYY format	27/01/2017
	@Size(min = 1, max = 5)
	@NotBlank
	private String reasonOfLiabilityToObtainRegistration;

	@NotNull
	private Character isCrossedTheThresholdLimit;

	@NotNull
	@Temporal(TemporalType.DATE)
	private Date DateOnWhichLiabilityToRegisterArises;

	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private ExistingRegistrationDetail existingRegistrationDetail;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "document_id")
	private List<DocumentsDetails> documentsDetails;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLegalNameOfBusiness() {
		return legalNameOfBusiness;
	}

	public void setLegalNameOfBusiness(String legalNameOfBusiness) {
		this.legalNameOfBusiness = legalNameOfBusiness;
	}
	
	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public String getConstitutionOfBusiness() {
		return constitutionOfBusiness;
	}

	public void setConstitutionOfBusiness(String constitutionOfBusiness) {
		this.constitutionOfBusiness = constitutionOfBusiness;
	}

	public PanDetails getPanDetails() {
		return panDetails;
	}

	public void setPanDetails(PanDetails panDetails) {
		this.panDetails = panDetails;
	}

	public StateCode getStateCode() {
		return stateCode;
	}

	public void setStateCode(StateCode stateCode) {
		this.stateCode = stateCode;
	}

	public JurisdictionDetails getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(JurisdictionDetails jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	public Character getOptedForComposition() {
		return OptedForComposition;
	}

	public void setOptedForComposition(Character optedForComposition) {
		OptedForComposition = optedForComposition;
	}

	public Date getDateOfCommencementOfBusiness() {
		return dateOfCommencementOfBusiness;
	}

	public void setDateOfCommencementOfBusiness(Date dateOfCommencementOfBusiness) {
		this.dateOfCommencementOfBusiness = dateOfCommencementOfBusiness;
	}

	public Character getAreYouCasualDealer() {
		return areYouCasualDealer;
	}

	public void setAreYouCasualDealer(Character areYouCasualDealer) {
		this.areYouCasualDealer = areYouCasualDealer;
	}

	public String getReasonOfLiabilityToObtainRegistration() {
		return reasonOfLiabilityToObtainRegistration;
	}

	public void setReasonOfLiabilityToObtainRegistration(String reasonOfLiabilityToObtainRegistration) {
		this.reasonOfLiabilityToObtainRegistration = reasonOfLiabilityToObtainRegistration;
	}

	public Character getIsCrossedTheThresholdLimit() {
		return isCrossedTheThresholdLimit;
	}

	public void setIsCrossedTheThresholdLimit(Character isCrossedTheThresholdLimit) {
		this.isCrossedTheThresholdLimit = isCrossedTheThresholdLimit;
	}

	public Date getDateOnWhichLiabilityToRegisterArises() {
		return DateOnWhichLiabilityToRegisterArises;
	}

	public void setDateOnWhichLiabilityToRegisterArises(Date dateOnWhichLiabilityToRegisterArises) {
		DateOnWhichLiabilityToRegisterArises = dateOnWhichLiabilityToRegisterArises;
	}

	public ExistingRegistrationDetail getExistingRegistrationDetail() {
		return existingRegistrationDetail;
	}

	public void setExistingRegistrationDetail(ExistingRegistrationDetail existingRegistrationDetail) {
		this.existingRegistrationDetail = existingRegistrationDetail;
	}

	public List<DocumentsDetails> getDocumentsDetails() {
		return documentsDetails;
	}

	public void setDocumentsDetails(List<DocumentsDetails> documentsDetails) {
		this.documentsDetails = documentsDetails;
	}

//	private String 	governmenttype;
//	private Date 	dateofliability;
//	private String 	district;

}
