 package com.anil.example.springboot.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;
    
    @NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    private String email;
    
    @NotBlank(message = "Phone number is mandatory")
    @Column(name = "phoneNo")
    @NotNull
    @Size(max = 10, min = 10, message = "Mobile number should be of 10 numbers")
   private String phoneNo;
    
    @Column(name = "Address")
    private String address;
    
    @Size(max = 10, min = 10, message = "Mobile number should be of 10 numbers")
    @Column(name ="alternate_phone_no")
    private String alternatePhoneNumber;
    
    @Column(name="interview_status")
    private String interviewStatus;
    
    @Size(max = 6, min = 6, message = "pincode should be of 6 digits")
    @Column(name="pincode")
    private String pincode;
    
    @Column(name="experience")
   private Integer experience;
	
    @Column(name="designation")
	private String designation;
    
    
    @Column(name="currentctc")
	private Integer currentctc;
    
    @Column(name="exceptedctc")
   	private Integer exceptedctc;
    
    @Column(name="pannel")
    private String pannel;
    
    @Column(name="created_date")
    private String createddate;
    
    @Column(name="created_by")
    private String createdby;

    @Column(name="modify_date")
    private String modifydate;

    @Column(name="modify_by")
    private String modifyby;

    

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAlternatePhoneNumber() {
		return alternatePhoneNumber;
	}

	public void setAlternatePhoneNumber(String alternatePhoneNumber) {
		this.alternatePhoneNumber = alternatePhoneNumber;
	}

	public String getInterviewStatus() {
		return interviewStatus;
	}

	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getCurrentctc() {
		return currentctc;
	}

	public void setCurrentctc(Integer currentctc) {
		this.currentctc = currentctc;
	}

	public Integer getExceptedctc() {
		return exceptedctc;
	}

	public void setExceptedctc(Integer exceptedctc) {
		this.exceptedctc = exceptedctc;
	}

	public String getPannel() {
		return pannel;
	}

	public void setPannel(String pannel) {
		this.pannel = pannel;
	}

 public Student(long id, @NotBlank(message = "Name is mandatory") String name,
			@NotBlank(message = "Email is mandatory") String email,
			@NotBlank(message = "Phone number is mandatory") @NotNull @Size(max = 10, min = 10, message = "Mobile number should be of 10 numbers") String phoneNo,
			String address,
			@Size(max = 10, min = 10, message = "Mobile number should be of 10 numbers") String alternatePhoneNumber,
			String interviewStatus, @Size(max = 6, min = 6, message = "pincode should be of 6 digits") String pincode,
			Integer experience, String designation, Integer currentctc, Integer exceptedctc, String pannel,
			String createddate, String createdby, String modifydate, String modifyby) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
		this.alternatePhoneNumber = alternatePhoneNumber;
		this.interviewStatus = interviewStatus;
		this.pincode = pincode;
		this.experience = experience;
		this.designation = designation;
		this.currentctc = currentctc;
		this.exceptedctc = exceptedctc;
		this.pannel = pannel;
		this.createddate = createddate;
		this.createdby = createdby;
		this.modifydate = modifydate;
		this.modifyby = modifyby;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getModifydate() {
		return modifydate;
	}

	public void setModifydate(String modifydate) {
		this.modifydate = modifydate;
	}

	public String getModifyby() {
		return modifyby;
	}

	public void setModifyby(String modifyby) {
		this.modifyby = modifyby;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + ", address="
				+ address + ", alternatePhoneNumber=" + alternatePhoneNumber + ", interviewStatus=" + interviewStatus
				+ ", pincode=" + pincode + ", experience=" + experience + ", designation=" + designation
				+ ", currentctc=" + currentctc + ", exceptedctc=" + exceptedctc + ", pannel=" + pannel
				+ ", createddate=" + createddate + ", createdby=" + createdby + ", modifydate=" + modifydate
				+ ", modifyby=" + modifyby + "]";
	}

	}