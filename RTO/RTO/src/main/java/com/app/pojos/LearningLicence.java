package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "learning_tbl")
public class LearningLicence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int applicantId;
	
	@Column(length = 20)
	@NotBlank(message = "Name is required")
	@Length(min = 3, max = 15, message = "Invalid name length")
	private String firstName = "abc";

	@Column(length = 20)
	@NotBlank(message = "Name is required")
	@Length(min = 3, max = 15, message = "Invalid name length")
	private String lastName = "xyz";

	@Column(length = 20, unique = true)
	@NotBlank(message = "Email is required")
	@Email(message = "Invalid Email Format ")
	private String email = "abc@gmail.com";

	@Column(length = 20, name = "aadhar_no")
	@NotBlank(message = "Aadhar_no is required")
	@Length(max = 12, message = "Invalid aadhar no length")
	private String aadharNo = "123456789000";

	@Column(length = 20, name = "mobile_no")
	@NotBlank(message = "Mobile_no is required")
	@Length(max = 10, message = "Invalid mobile no length")
	private String mobileNo = "1234567890";

	@Column(name = "dob")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	private LocalDate dob;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender", length = 20)
	private Gender gender;

	@Enumerated(EnumType.STRING)
	@Column(name = "blood_group", length = 20)
	private BloodGroup bloodGroup;

	@Column(name = "identification_mark", length = 20)
	@NotBlank(message = "Identification Mark is required")
	@Length(min = 1, max = 25, message = "Invalid ")
	private String identificationMark;

	@Column(length = 20)
	@NotBlank(message = "State is required")
	@Length(min = 1, max = 25, message = "Invalid State ")
	private String state;

	@Column(length = 20)
	@NotBlank(message = "District is required")
	@Length(min = 1, max = 25, message = "Invalid district")
	private String district;

	@Column(length = 20)
	@NotBlank(message = "Village/town is required")
	@Length(min = 1, max = 25, message = "Invalid Village/town ")
	private String village;

	@Column(length = 20)
	@NotBlank(message = "landmark is required")
	@Length(min = 1, max = 25, message = "Invalid landmark ")
	private String landmark;

	@Column(length = 20)
	@NotBlank(message = "PinCode is required")
	@Length(min = 1, max = 6, message = "Invalid Pincode ")
	private String pincode;

	@Column(length = 20)
	@NotBlank(message = "Street is required")
	@Length(min = 1, max = 50, message = "Invalid Street ")
	private String street;
	
	@OneToOne(mappedBy = "learningLicense",cascade = CascadeType.ALL, orphanRemoval = true)
	private Appointment appointment;
	
	public LearningLicence() {
		// TODO Auto-generated constructor stub
	}

	public LearningLicence(String firstName, String lastName, String email, String aadharNo, String mobileNo,
			LocalDate dob, Gender gender, BloodGroup bloodGroup, String identificationMark, String state,
			String district, String village, String landmark, String pincode, String street, Appointment appointment) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.aadharNo = aadharNo;
		this.mobileNo = mobileNo;
		this.dob = dob;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.identificationMark = identificationMark;
		this.state = state;
		this.district = district;
		this.village = village;
		this.landmark = landmark;
		this.pincode = pincode;
		this.street = street;
		this.appointment=appointment;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public int getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getIdentificationMark() {
		return identificationMark;
	}

	public void setIdentificationMark(String identificationMark) {
		this.identificationMark = identificationMark;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "LearningLicence [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", aadharNo="
				+ aadharNo + ", mobileNo=" + mobileNo + ", dob=" + dob + ", gender=" + gender + ", bloodGroup="
				+ bloodGroup + ", identificationMark=" + identificationMark + ", state=" + state + ", district="
				+ district + ", village=" + village + ", landmark=" + landmark + ", pincode=" + pincode + ", street="
				+ street + "]";
	}

}
