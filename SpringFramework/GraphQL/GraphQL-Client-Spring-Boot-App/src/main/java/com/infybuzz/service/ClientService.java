package com.infybuzz.service;

import com.infybuzz.request.CreateStudentRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infybuzz.response.StudentResponse;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class ClientService {

	@Autowired
	GraphQLWebClient graphQLWebClient;

	public StudentResponse getStudent (Integer id) {
		log.info("getStudent");

		Map<String, Object> variables = new HashMap<>();
		variables.put("id", id);
		String queryStr = "query student ($id : Int) {\n" +
				"  student (id : $id) {\n" +
				"    id\n" +
				"    firstName\n" +
				"    lastName\n" +
				"    email\n" +
				"    street\n" +
				"    city\n" +
				"    learningSubjects(subjectNameFilter: All) {\n" +
				"      id\n" +
				"      subjectName\n" +
				"      marksObtained\n" +
				"    }\n" +
				"    fullName\n" +
				"  }\n" +
				"}";

		GraphQLRequest request = GraphQLRequest.builder()
				.query(queryStr).variables(variables).build();
		GraphQLResponse response = graphQLWebClient.post(request).block();

		return response.get("student", StudentResponse.class);
	}

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
		log.info("createStudent");

		Map<String, Object> variables = new HashMap<>();
		variables.put("createStudentRequest", createStudentRequest);

		String mutationStr = "mutation createStudent ($createStudentRequest : CreateStudentRequest) {\n" +
				"  createStudent(createStudentRequest : $createStudentRequest) {\n" +
				"    firstName\n" +
				"    lastName\n" +
				"    email\n" +
				"    street\n" +
				"    city\n" +
				"    learningSubjects(subjectNameFilter: All) {\n" +
				"      subjectName\n" +
				"      marksObtained\n" +
				"    }\n" +
				"    fullName\n" +
				"  } \n" +
				"}";

		GraphQLRequest request = GraphQLRequest.builder()
				.query(mutationStr).variables(variables).build();
		GraphQLResponse response = graphQLWebClient.post(request).block();

		return response.get("createStudent", StudentResponse.class);
	}
}
