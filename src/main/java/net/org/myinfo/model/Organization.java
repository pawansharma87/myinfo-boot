package net.org.myinfo.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "org_tab")
public class Organization {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long userId;
	@Length(min = 4, max = 35)
	@NotNull
	@NotBlank
	private String orgName;
	/*private String orgType;*/
	private String orgSubType;
	@NotNull
	@Length(min = 4, max = 100)
	private String speciality;
	@NotNull
	@Length(min = 4, max = 100)
	private String facility;
	@NotNull
	@Length(min = 4, max = 35)
	private String contactPerson;
	private String phone;
	@NotNull
	//@Range(min = 8, max = 10)
	private String mobile;
	@Email
	private String email;
	private String web;
	@NotNull
	private String address;
	@NotNull
	private String state;
	@NotNull
	private String distt;
	@NotNull
	private String city;
	@NotNull
	//@Range(min = 4, max = 6)
	private String pin;
	private String howtoreach;
	
	 private Date dateCreated;

	    @Version
	    private Timestamp dateModified;

	    @PrePersist
	    void createdAt() {
	        this.setDateCreated(new Date());
	    }
	     
	    public Date getDateCreated() {
	        return dateCreated;
	    }

	    public void setDateCreated(Date dateCreated) {
	        this.dateCreated = dateCreated;
	    }

	    public Timestamp getDateModified() {
	        return dateModified;
	    }

	    public void setDateModified(Timestamp dateModified) {
	        this.dateModified = dateModified;
	    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

/*	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}*/

	public String getOrgSubType() {
		return orgSubType;
	}

	public void setOrgSubType(String orgSubType) {
		this.orgSubType = orgSubType;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistt() {
		return distt;
	}

	public void setDistt(String distt) {
		this.distt = distt;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getHowtoreach() {
		return howtoreach;
	}

	public void setHowtoreach(String howtoreach) {
		this.howtoreach = howtoreach;
	}
}
