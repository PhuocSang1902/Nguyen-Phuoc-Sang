package com.example.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.dto.response.StudentResponse;
import com.example.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.dto.request.RequestFullName;

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
