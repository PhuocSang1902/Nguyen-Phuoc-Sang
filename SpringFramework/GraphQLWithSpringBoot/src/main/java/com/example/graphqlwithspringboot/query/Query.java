package com.example.graphqlwithspringboot.query;

import com.example.graphqlwithspringboot.dto.response.StudentResponse;
import com.example.graphqlwithspringboot.service.StudentService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.graphqlwithspringboot.dto.request.RequestFullName;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    StudentService studentService;

    public String firstQuery(){
        return "First Query";
    }

    public String secondQuery(){
        return "Second Query";
    }

    public String fullName(RequestFullName request){
        return request.getFirstName() + " " + request.getLastName();
    }

    public StudentResponse getStudent(Long id){
        return new StudentResponse(studentService.getStudentById(id));
    }
}
