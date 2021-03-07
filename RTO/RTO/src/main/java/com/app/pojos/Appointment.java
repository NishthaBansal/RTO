package com.app.pojos;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "Appointment")
public class Appointment extends BaseEntity{

	@Column(name = "created_at")
	private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
	
	@Column(name = "appointment_date")
	@DateTimeFormat(iso = ISO.DATE)
	@Future
	private LocalDate appointmentDate;
	
	@Column(name = "appointment_time")
	@DateTimeFormat(iso = ISO.TIME)
	private LocalTime appointmentTime;
	
	@Column(name = "appointment_status")
	@Enumerated(EnumType.STRING)
	private AppointmentStatus appointmentStatus = AppointmentStatus.BOOKED;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "applicant_id")
	private LearningLicence learningLicense;

	public Appointment() {
		// TODO Auto-generated constructor stub
	}

	public Appointment(Timestamp createdAt, @Future LocalDate appointmentDate,
			LocalTime appointmentTime, AppointmentStatus appointmentStatus, LearningLicence learningLicense) {
		super();
		this.createdAt = createdAt;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.appointmentStatus = appointmentStatus;
		this.learningLicense = learningLicense;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(LocalTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public AppointmentStatus getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	public LearningLicence getLearningLicense() {
		return learningLicense;
	}

	public void setLearningLicense(LearningLicence learningLicense) {
		this.learningLicense = learningLicense;
	}
	
}
