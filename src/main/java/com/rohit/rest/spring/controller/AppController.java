package com.rohit.rest.spring.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.rest.spring.model.Person;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AppController {

	@GetMapping("/land")
	public Person getLanding(@RequestParam(value = "name", defaultValue = "testName") String name,
			@RequestParam(value = "id", defaultValue = "007") String id) {
		return new Person(name, id);
	}

	@GetMapping({ "/{name}/{id}", "/{name}", "//{id}", "/" })
	public Person getWelcomed(@PathVariable(value = "name", required = false) String name,
			@PathVariable(value = "id", required = false) String id) {
		name = StringUtils.isEmpty(name) ? "testName" : name;
		id = StringUtils.isEmpty(id) ? "007" : id;
		return new Person(name, id);
	}

}
