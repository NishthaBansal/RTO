package com.app.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.LearningLicenceRepo;
import com.app.pojos.Appointment;
import com.app.pojos.LearningLicence;
import com.app.service.IAppointmentService;

@Controller
@RequestMapping("/learning")
public class LearningController {

	@Autowired
	private LearningLicenceRepo learningRepo;
	@Autowired
	private IAppointmentService appointmentService;

	@GetMapping("/form")
	public String ShowLearningForm(Model modelMap, LearningLicence ll) {
		System.out.println("in learning form ");
		return "/learning/form";
	}

	@PostMapping("/form")
	public String fillLearningForm(@Valid LearningLicence learnerLicense, BindingResult res, RedirectAttributes flashMap,
			Model modelMap, HttpSession hs) {
		if (res.hasErrors()) {
			return "/learning/form";
		}
		LearningLicence applicant = learningRepo.save(learnerLicense);
		flashMap.addAttribute("message", applicant);
		hs.setAttribute("status",applicant.getApplicantId());
		return "redirect:/learning/book-your-slot";
	}
	
	@GetMapping("/book-your-slot")
	public String ShowBookingSlot(Model modelMap, Appointment appointment) {
		System.out.println("in learning form ");
		
		return "/learning/book-your-slot";
	}
	
	@RequestMapping(value = "/book-your-slot", method = RequestMethod.POST,  consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
	        produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment create(@Valid Appointment appointment,
    						Model modelMap, HttpSession hs) {
		int  applicantId = (int) hs.getAttribute("status");
		  return appointmentService.create(applicantId, appointment);
      
    }
}
