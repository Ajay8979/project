package com.ojas.gst.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author akrishna
 *
 */
@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FileGSTR3BData implements com.ojas.gst.entity.Entity {

	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String gstin;
	@Column(name="ret_period")
	private String ret_period;
	private String ref_id;;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "sub_id")
	private DetailsofOutwardSupplies sup_details;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "inter_id")
	private InterStateSupplies inter_sup;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "itc_id")
	private EligibleITC itc_elg;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "inward_id")
	private InwardSupplyDetails inward_sup;
	//remove PaymentOfTax for Save GSTR3B data
	
	/*@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "tx_id")
	private PaymentOfTax tx_pmt;*/
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "ltfee_id")
	private InterestLateFee intr_ltfee;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getGstin() {
		return gstin;
	}
	public void setGstin(String gstin) {
		this.gstin = gstin;
	}
	public String getRet_period() {
		return ret_period;
	}
	public void setRet_period(String ret_period) {
		this.ret_period = ret_period;
	}
	public DetailsofOutwardSupplies getSup_details() {
		return sup_details;
	}
	public void setSup_details(DetailsofOutwardSupplies sup_details) {
		this.sup_details = sup_details;
	}
	public InterStateSupplies getInter_sup() {
		return inter_sup;
	}
	public void setInter_sup(InterStateSupplies inter_sup) {
		this.inter_sup = inter_sup;
	}
	public EligibleITC getItc_elg() {
		return itc_elg;
	}
	public void setItc_elg(EligibleITC itc_elg) {
		this.itc_elg = itc_elg;
	}
	public InwardSupplyDetails getInward_sup() {
		return inward_sup;
	}
	public void setInward_sup(InwardSupplyDetails inward_sup) {
		this.inward_sup = inward_sup;
	}
	
	public InterestLateFee getIntr_ltfee() {
		return intr_ltfee;
	}
	public void setIntr_ltfee(InterestLateFee intr_ltfee) {
		this.intr_ltfee = intr_ltfee;
	}
	
	@Override
	public String toString() {
		return "FileGSTR3BData [id=" + id + ", gstin=" + gstin + ", ret_period=" + ret_period + ", sup_details="
				+ sup_details + ", inter_sup=" + inter_sup + ", itc_elg=" + itc_elg + ", inward_sup=" + inward_sup
				+ ", intr_ltfee=" + intr_ltfee + "]";
	}


	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}


	public String getRef_id() {
		return ref_id;
	}


	public void setRef_id(String ref_id) {
		this.ref_id = ref_id;
	}


	
}
