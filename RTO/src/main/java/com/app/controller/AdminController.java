package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.LearningLicenceRepo;
import com.app.pojos.LearningLicence;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private LearningLicenceRepo learningRepo;

	public AdminController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	@GetMapping("/admin")
	public String showUserList(Model map) {
		System.out.println("in admin show list ");

		map.addAttribute("user_list", learningRepo.findAll());
		return "/admin/admin";

	}

	@GetMapping("/edit")
	public String showEditPage(Model modelMap, LearningLicence ll) {
		System.out.println("in show edit page ");
		return "/admin/edit";
	}

	/*
	 * @PostMapping("/edit") public String editPage()
	 */
	
	
	
	
	
	

}
