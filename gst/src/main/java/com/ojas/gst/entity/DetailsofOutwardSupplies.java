package com.ojas.gst.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DetailsofOutwardSupplies implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "det_id")
	private OutwardTaxableSupplies osup_det;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "zero_id")
	private OutwardZeroSupplies osup_zero;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "exmp_id")
	private OutwardSupplyExempted osup_nil_exmp;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "rev_id")
	private InwardSuppliesReverse isup_rev;


	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "nongst_id")
	private NonGSTOutwardSupplies osup_nongst;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public OutwardTaxableSupplies getOsup_det() {
		return osup_det;
	}
	public void setOsup_det(OutwardTaxableSupplies osup_det) {
		this.osup_det = osup_det;
	}
	public OutwardZeroSupplies getOsup_zero() {
		return osup_zero;
	}
	public void setOsup_zero(OutwardZeroSupplies osup_zero) {
		this.osup_zero = osup_zero;
	}
	public OutwardSupplyExempted getOsup_nil_exmp() {
		return osup_nil_exmp;
	}
	public void setOsup_nil_exmp(OutwardSupplyExempted osup_nil_exmp) {
		this.osup_nil_exmp = osup_nil_exmp;
	}
	public InwardSuppliesReverse getIsup_rev() {
		return isup_rev;
	}
	public void setIsup_rev(InwardSuppliesReverse isup_rev) {
		this.isup_rev = isup_rev;
	}
	public NonGSTOutwardSupplies getOsup_nongst() {
		return osup_nongst;
	}
	public void setOsup_nongst(NonGSTOutwardSupplies osup_nongst) {
		this.osup_nongst = osup_nongst;
	}
	
	
	
}
