package com.ojas.gst.entity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ojas.gst.enums.StateCode;

@javax.persistence.Entity
@Table(name = "gst_address_details")
public class Address implements Entity{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "addr_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "building_number")
	private String buildingNumber;	
	
	@Column(name = "floor_number")
	private String floorNumber;
	
	@Column(name = "premises_Building")
	private String premisesOrBuilding;
	
	@Column(name = "street_road")
	private String streetOrRoad;
	
	@Column(name = "locality")	
	private String locality;
	
	@Column(name = "country")
	private String country;
	
	@Enumerated(EnumType.ORDINAL)
	private StateCode state;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "pinCode")
	private Integer pinCode;
	
	private String latitudedetails;
	
	private String longitudedetails;
	
	public Address(String buildingNumber, String floorNumber, String premisesOrBuilding, String streetOrRoad,
			String locality, String country, StateCode state, String district, Integer pinCode, String latitudedetails,
			String longitudedetails) {
		super();
		this.buildingNumber = buildingNumber;
		this.floorNumber = floorNumber;
		this.premisesOrBuilding = premisesOrBuilding;
		this.streetOrRoad = streetOrRoad;
		this.locality = locality;
		this.country = country;
		this.state = state;
		this.district = district;
		this.pinCode = pinCode;
		this.latitudedetails = latitudedetails;
		this.longitudedetails = longitudedetails;
	}
	
	public Address() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public String getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(String floorNumber) {
		this.floorNumber = floorNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public String getLatitudedetails() {
		return latitudedetails;
	}

	public void setLatitudedetails(String latitudedetails) {
		this.latitudedetails = latitudedetails;
	}

	public String getLongitudedetails() {
		return longitudedetails;
	}

	public void setLongitudedetails(String longitudedetails) {
		this.longitudedetails = longitudedetails;
	}


	public String getPremisesOrBuilding() {
		return premisesOrBuilding;
	}

	public void setPremisesOrBuilding(String premisesOrBuilding) {
		this.premisesOrBuilding = premisesOrBuilding;
	}

	public String getStreetOrRoad() {
		return streetOrRoad;
	}

	public void setStreetOrRoad(String streetOrRoad) {
		this.streetOrRoad = streetOrRoad;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public StateCode getState() {
		return state;
	}

	public void setState(StateCode state) {
		this.state = state;
	}
}
