package org.houor.spring.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.houor.spring.rest.domain.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

	public static int count = 0;

	@RequestMapping("/getNo")
	public Message getMessage(@RequestParam("name")String name) {
		Message message = new Message(String.valueOf(++count), name);
		return message;
	}
	
	@RequestMapping("/messages")
	public List<Message> getMessages() {
		List<Message> list = new ArrayList<Message>();
		for (int i = 0; i < 5; i++) {
			Message message = new Message(String.valueOf(++count), "aa");
			list.add(message);
		}
		
		
		return list;
	}

}
