package org.houor.spring.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.houor.spring.rest.domain.Spittle;
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

	private static Map<Long, Spittle> map = new HashMap<Long, Spittle>();

	@RequestMapping(method = RequestMethod.GET)
	public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
			@RequestParam(value = "count", defaultValue = "20") int count) {
		System.out.println("max = " + max + ", count = " + count);
		List<Spittle> spittleList = new ArrayList<Spittle>();
		spittleList.addAll(map.values());
		if (max == Long.valueOf(MAX_LONG_AS_STRING)) {
			max = 0;
		}
		return spittleList.subList((int) max, spittleList.size());
	}

	@RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
	public String showSpittle(@PathVariable("spittleId") long spittleId, Model model) {
		System.out.println("find id = " + spittleId);
		model.addAttribute("spittle", map.get(spittleId));

		return "spittle";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveSpittle(SpittleForm form, Model model) throws Exception {
		System.out.println(form.getMessage());
		if (form.getMessage() != null) {
			Spittle spittle = form.genSpittle();
			map.put(spittle.getId(), spittle);
		}

		return "redirect:/spittles";
	}

}
