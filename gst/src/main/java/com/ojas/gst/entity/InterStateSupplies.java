package com.ojas.gst.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class InterStateSupplies implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "inter_sup_id")
	private List<UnregisteredPersons> unreg_details;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "comp_details_id")
	private List<CompositionTaxablePersons>  comp_details;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "uin_details_id")
	private List<UINHolders> uin_details;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<UnregisteredPersons> getUnreg_details() {
		return unreg_details;
	}
	public void setUnreg_details(List<UnregisteredPersons> unreg_details) {
		this.unreg_details = unreg_details;
	}
	public List<CompositionTaxablePersons> getComp_details() {
		return comp_details;
	}
	public void setComp_details(List<CompositionTaxablePersons> comp_details) {
		this.comp_details = comp_details;
	}
	public List<UINHolders> getUin_details() {
		return uin_details;
	}
	public void setUin_details(List<UINHolders> uin_details) {
		this.uin_details = uin_details;
	}
	
	
}
