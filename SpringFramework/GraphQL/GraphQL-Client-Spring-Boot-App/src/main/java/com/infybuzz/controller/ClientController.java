package com.infybuzz.controller;

import com.infybuzz.request.CreateStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.infybuzz.response.StudentResponse;
import com.infybuzz.service.ClientService;

@RestController
@RequestMapping("/api/student")
public class ClientController {
	
	@Autowired
	ClientService clientService;

	@GetMapping("/get/{id}")
	public StudentResponse getStudent(@PathVariable Integer id) {
		return clientService.getStudent(id);
	}

	@PostMapping("/create")
	public StudentResponse createStudent(@RequestBody CreateStudentRequest createStudentRequest){
		return clientService.createStudent(createStudentRequest);
	}
	
}
