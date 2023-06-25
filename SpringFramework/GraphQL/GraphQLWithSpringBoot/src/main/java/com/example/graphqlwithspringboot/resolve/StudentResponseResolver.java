package com.example.graphqlwithspringboot.resolve;

import com.example.graphqlwithspringboot.dto.response.StudentResponse;
import com.example.graphqlwithspringboot.dto.response.SubjectResponse;
import com.example.graphqlwithspringboot.entity.Subject;
import com.example.graphqlwithspringboot.enums.SubjectNameFilter;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {

    public List<SubjectResponse> getLearningSubjects(StudentResponse studentResponse, SubjectNameFilter subjectNameFilter) {

        List<SubjectResponse> learningSubjects = new ArrayList<>();

        if (studentResponse.getStudent().getLearningSubjects() != null) {
            for (Subject subject : studentResponse.getStudent().getLearningSubjects()) {
                if (subjectNameFilter.name().equalsIgnoreCase("All")){
                    learningSubjects.add(new SubjectResponse(subject));
                }
                if (subjectNameFilter.name().equalsIgnoreCase(subject.getSubjectName())){
                    learningSubjects.add(new SubjectResponse(subject));
                }
            }
        }
        return learningSubjects;
    }

    public String getFullName(StudentResponse studentResponse) {
        return studentResponse.getFirstName() + " " + studentResponse.getLastName();
    }
}