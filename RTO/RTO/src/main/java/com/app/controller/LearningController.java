package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dao.LearningLicenceRepo;
import com.app.pojos.LearningLicence;

@Controller
@RequestMapping("/learning")
public class LearningController {

	@Autowired
	private LearningLicenceRepo learningRepo;

	@GetMapping("/form")
	public String ShowLearningForm(Model modelMap, LearningLicence ll) {
		System.out.println("in learning form ");
		return "/learning/form";
	}

	@PostMapping("/form")
	public String fillLearningForm(@Valid LearningLicence ll, BindingResult res, RedirectAttributes flashMap,
			Model modelMap) {
		if (res.hasErrors()) {
			return "/learning/form";
		}
		flashMap.addAttribute("message", learningRepo.save(ll));

		return "redirect:/user/login";
	}

}
