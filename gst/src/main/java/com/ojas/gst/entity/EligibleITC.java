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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Table
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EligibleITC implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "itc_avl_id")
	private List<ITCAvailable> itc_avl;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "itc_rev_id")
	private List<ITCReversed> itc_rev;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "itc_net_id")
	private NetITCAvailable itc_net;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "itc_inelg_id")
	private List<IneligibleITC> itc_inelg;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<ITCAvailable> getItc_avl() {
		return itc_avl;
	}
	public void setItc_avl(List<ITCAvailable> itc_avl) {
		this.itc_avl = itc_avl;
	}
	public List<ITCReversed> getItc_rev() {
		return itc_rev;
	}
	public void setItc_rev(List<ITCReversed> itc_rev) {
		this.itc_rev = itc_rev;
	}
	public NetITCAvailable getItc_net() {
		return itc_net;
	}
	public void setItc_net(NetITCAvailable itc_net) {
		this.itc_net = itc_net;
	}
	public List<IneligibleITC> getItc_inelg() {
		return itc_inelg;
	}
	public void setItc_inelg(List<IneligibleITC> itc_inelg) {
		this.itc_inelg = itc_inelg;
	}
	
	
	
}
