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
public class InwardSupplyDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "isup_details_id")
	private List<UpwardSuppliers> isup_details;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<UpwardSuppliers> getIsup_details() {
		return isup_details;
	}

	public void setIsup_details(List<UpwardSuppliers> isup_details) {
		this.isup_details = isup_details;
	}

	
	
}
