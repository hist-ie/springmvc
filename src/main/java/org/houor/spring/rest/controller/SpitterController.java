package org.houor.spring.rest.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.houor.spring.rest.domain.Spitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	private static Map<String, Spitter> map = new HashMap<String, Spitter>();

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute("spitter", new Spitter());
		return "registerForm";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegistration(@Valid Spitter spitter, Errors errors) {

		if (errors.hasErrors()) {
			for (ObjectError oe : errors.getAllErrors()) {
				System.out.println(oe.toString());
			}
			return "registerForm";
		}

		System.out.println(spitter.getFirstName());
		System.out.println(spitter.getLastName());
		System.out.println(spitter.getEmail());
		System.out.println(spitter.getUsername());
		System.out.println(spitter.getPassword());
		map.put(spitter.getUsername(), spitter);
		return "redirect:/spitter/" + spitter.getUsername();
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String username, Model model) {

		Spitter spitter = map.get(username);
		model.addAttribute(spitter);

		return "profile";
	}

}
