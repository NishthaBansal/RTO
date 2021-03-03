package com.app.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	public UserController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/user/login";
	}

	@PostMapping("/login") // @PostMapping => @RequestMapping: method=post
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model modelMap,
			HttpSession hs) {
		System.out.println("in process login form " + email + " " + password);
		try {

			User user = userService.authenticateUser(email, password);
			hs.setAttribute("user_details", user);
			hs.setAttribute("message", user.getFirstName() + " Logged in succesfully");

			// , check user's role
			if (user.getRole().equals(Role.ADMIN))
				return "redirect:/admin/admin";

			if (user.getRole().equals(Role.CITIZEN))
				// User has logged in
				return "/user/page";

		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);

			modelMap.addAttribute("message", "Invalid Login ,Please retry!!!!");
			// => invalid login
			return "/user/login";
		}
		return "/user/page";
	}

	@GetMapping("/register")
	public String showRegForm(Model modelMap, User u) {
		System.out.println("in reg form " + modelMap);
		return "/user/register";
	}

	@PostMapping("/register")
	public String processRegForm(@Valid User u, BindingResult res, RedirectAttributes flashMap, Model modelMap) {
		System.out.println("in preg form : user details " + u);
		if (res.hasErrors()) {
			return "/user/register";
		}

		flashMap.addFlashAttribute("message", userService.registerUser(u));
		return "redirect:/user/login";

	}

}
