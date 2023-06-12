package com.example.resolve;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.dto.response.StudentResponse;
import com.example.dto.response.SubjectResponse;
import com.example.entity.Subject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {
    public List<SubjectResponse> getLearningSubjects(StudentResponse studentResponse) {

        List<SubjectResponse> learningSubjects = new ArrayList<>();

        if (studentResponse.getStudent().getLearningSubjects() != null) {
            for (Subject subject : studentResponse.getStudent().getLearningSubjects()) {
                learningSubjects.add(new SubjectResponse(subject));
            }
        }
        return learningSubjects;
    }
}
