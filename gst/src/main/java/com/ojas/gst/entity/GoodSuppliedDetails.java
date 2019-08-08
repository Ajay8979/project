package com.ojas.gst.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "good_supplies")
public class GoodSuppliedDetails implements com.ojas.gst.dao.Entity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "good_supplies_id")
	private Long id;
	
	@Max(30)
	@NotBlank
	private String descriptionOfGoodsSupplied;
	
	@NotNull
	private Integer hsnCode;
	
	@ManyToOne
	private GoodAndServiceDetails goodAndServiceDetails;
	
	public GoodSuppliedDetails( @Max(30) @NotBlank String descriptionOfGoodsSupplied, @NotNull Integer hsnCode) {
		super();
		this.descriptionOfGoodsSupplied = descriptionOfGoodsSupplied;
		this.hsnCode = hsnCode;
	}
	
	public GoodSuppliedDetails() { }

	public GoodAndServiceDetails getGoodAndServiceDetails() {
		return goodAndServiceDetails;
	}

	public void setGoodAndServiceDetails(GoodAndServiceDetails goodAndServiceDetails) {
		this.goodAndServiceDetails = goodAndServiceDetails;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescriptionOfGoodsSupplied() {
		return descriptionOfGoodsSupplied;
	}

	public void setDescriptionOfGoodsSupplied(String descriptionOfGoodsSupplied) {
		this.descriptionOfGoodsSupplied = descriptionOfGoodsSupplied;
	}

	public Integer getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(Integer hsnCode) {
		this.hsnCode = hsnCode;
	}

}
