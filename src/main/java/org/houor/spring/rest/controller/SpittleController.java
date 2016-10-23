package org.houor.spring.rest.controller;

import java.util.List;

import org.houor.spring.rest.domain.Spittle;
import org.houor.spring.rest.service.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

	private static final String MAX_LONG_AS_STRING = "9223372036854775807";

	@Autowired
	SpittleRepository spittleRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
			@RequestParam(value = "count", defaultValue = "20") int count) {
		System.out.println("max = " + max + ", count = " + count);
		return spittleRepository.findSpittles(max, count);
	}

	@RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
	public String showSpittle(@PathVariable("spittleId") long spittleId, Model model) {
		System.out.println("find id = " + spittleId);
		model.addAttribute(spittleRepository.findOne(spittleId));

		return "spittle";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveSpittle(SpittleForm form, Model model) throws Exception {
		System.out.println(form.getMessage());

		return "redirect:/spittles";
	}

}
