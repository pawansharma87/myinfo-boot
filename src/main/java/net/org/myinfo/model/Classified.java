/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.org.myinfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author er
 */
@Entity
@Table(name = "cd_classified_tab")
public class Classified {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long classified_id;
	@Column(name = "userId")
	private Long userId;
	private String roomType;
	private Integer rent;
	@Size(min = 3, max = 100, message = "Contact person must at least 3 characters.")
	@NotNull
	private String contactPerson;
	@NotNull
	private String mobile;
	private String email;
	@NotNull
	private String address;
	private String state;
	private String distt;
	private String city;
	private String pin;
	private String description;

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getRoomType() {
		return roomType;
	}

	public Long getClassified_id() {
		return classified_id;
	}

	public void setClassified_id(Long classified_id) {
		this.classified_id = classified_id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Integer getRent() {
		return rent;
	}

	public void setRent(Integer rent) {
		this.rent = rent;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDistt() {
		return distt;
	}

	public void setDistt(String distt) {
		this.distt = distt;
	}

	public String getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
