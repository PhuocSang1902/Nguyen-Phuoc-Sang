package com.example.graphqlwithspringboot.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphqlwithspringboot.dto.request.CreateStudentRequest;
import com.example.graphqlwithspringboot.dto.response.StudentResponse;
import com.example.graphqlwithspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    StudentService studentService;

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest){
        return new StudentResponse(studentService.createStudent(createStudentRequest));
    }
}
