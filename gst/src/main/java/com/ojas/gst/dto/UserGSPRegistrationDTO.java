package com.ojas.gst.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserGSPRegistrationDTO {
	
private String userName;	
private String password;
private String role;
private String clientName;
private String type;
private String address;
private String state;
private String city;
private Long pinCode;
private String panNumber;
private String relationShip;
private String servicesRequired;
private String eamilAddress;
private Long mobileNumber;
private String status;
public String getClientName() {
	return clientName;
}
public void setClientName(String clientName) {
	this.clientName = clientName;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public Long getPinCode() {
	return pinCode;
}
public void setPinCode(Long pinCode) {
	this.pinCode = pinCode;
}
public String getPanNumber() {
	return panNumber;
}
public void setPanNumber(String panNumber) {
	this.panNumber = panNumber;
}
public String getRelationShip() {
	return relationShip;
}
public void setRelationShip(String relationShip) {
	this.relationShip = relationShip;
}
public String getServicesRequired() {
	return servicesRequired;
}
public void setServicesRequired(String servicesRequired) {
	this.servicesRequired = servicesRequired;
}
public String getEamilAddress() {
	return eamilAddress;
}
public void setEamilAddress(String eamilAddress) {
	this.eamilAddress = eamilAddress;
}
public Long getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(Long mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}


}
