package com.ojas.gst.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "GoodAndService")
public class GoodAndServiceDetails implements com.ojas.gst.dao.Entity {

	@Id
	@Column(name = "goodservice_id")
	private Long id;
	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="good_supplies_id")
	private List<GoodSuppliedDetails> goodSuppliedList;
	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="service_supplies_id")
	private List<ServicesSuppliedDetails> serviceSuppliedList;
	
	public GoodAndServiceDetails(List<GoodSuppliedDetails> goodSuppliedList,
			List<ServicesSuppliedDetails> serviceSuppliedList) {
		super();
		this.goodSuppliedList = goodSuppliedList;
		this.serviceSuppliedList = serviceSuppliedList;
	}
	public GoodAndServiceDetails() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<GoodSuppliedDetails> getGoodSuppliedList() {
		return goodSuppliedList;
	}

	public void setGoodSuppliedList(List<GoodSuppliedDetails> goodSuppliedList) {
		this.goodSuppliedList = goodSuppliedList;
	}

	public List<ServicesSuppliedDetails> getServiceSuppliedList() {
		return serviceSuppliedList;
	}

	public void setServiceSuppliedList(List<ServicesSuppliedDetails> serviceSuppliedList) {
		this.serviceSuppliedList = serviceSuppliedList;
	}
}
