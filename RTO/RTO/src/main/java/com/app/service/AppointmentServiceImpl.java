package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AppointmentRepository;
import com.app.dao.LearningLicenceRepo;
import com.app.pojos.Appointment;
import com.app.pojos.LearningLicence;

@Service
public class AppointmentServiceImpl implements IAppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepo;
	@Autowired
	private LearningLicenceRepo l;
	
	@Override
	public Optional<Appointment> findById(Integer applicantId) {
		return appointmentRepo.findById(applicantId);
	}
	
	@Override
	public Appointment create(Integer lId, Appointment appointment) {
		Optional<LearningLicence> ll = l.findById(lId);
		// TODO : if(ll == null) not ll present 
		appointment.setLearningLicense(ll.get());
	        return appointmentRepo.save(appointment);
	}
	
	@Override
	public Appointment updateStatus(Integer applicantId, Appointment appointment) {
		Optional<Appointment> appointmentList = appointmentRepo.findById(applicantId);
		
		if(appointmentList.isPresent()) {
			if(appointment.getAppointmentStatus() != null) {
				appointmentList.get().setAppointmentStatus(appointment.getAppointmentStatus());
			}
		}
		  return appointmentRepo.save(appointmentList.get());
	}

	@Override
	public void deleteById(Integer applicantId) {
		appointmentRepo.deleteById(applicantId);
		
	}


	

}
