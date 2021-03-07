package com.app.service;

import java.util.Optional;

import com.app.pojos.Appointment;

public interface IAppointmentService {
	
	 Optional<Appointment> findById(Integer applicantId);
	 
	 Appointment create(Integer applicantId, Appointment appointment);
	 
	 Appointment updateStatus(Integer applicantId, Appointment appointment);
	 
	 void deleteById(Integer applicantId);
}
