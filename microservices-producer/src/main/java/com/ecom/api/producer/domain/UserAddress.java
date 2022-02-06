package com.ecom.api.producer.domain;

import java.util.Date;

import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user_address")
public class UserAddress{
	
	@Id
	private int id;
	private int userId;
	private String address1;
	private String address2;
	private String city;
	private String district;
	private String post;
	private String zipCode;
	private boolean defaultAddress;
	private Date createdDateTime;
	private String createdBy;
	private Date updatedDateTime;
	private String updatedBy;

	public UserAddress() {
	}

	public UserAddress(int id, int userId, String address1, String address2, String city, String district, String post,
			String zipCode, boolean defaultAddress, Date createdDateTime, String createdBy, Date updatedDateTime,
			String updatedBy) {
		super();
		this.id = id;
		this.userId = userId;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.district = district;
		this.post = post;
		this.zipCode = zipCode;
		this.defaultAddress = defaultAddress;
		this.createdDateTime = createdDateTime;
		this.createdBy = createdBy;
		this.updatedDateTime = updatedDateTime;
		this.updatedBy = updatedBy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public boolean isDefaultAddress() {
		return defaultAddress;
	}

	public void setDefaultAddress(boolean defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "UserAddress [id=" + id + ", userId=" + userId + ", address1=" + address1 + ", address2=" + address2
				+ ", city=" + city + ", district=" + district + ", post=" + post + ", zipCode=" + zipCode
				+ ", defaultAddress=" + defaultAddress + ", createdDateTime=" + createdDateTime + ", createdBy="
				+ createdBy + ", updatedDateTime=" + updatedDateTime + ", updatedBy=" + updatedBy + "]";
	}	
}
