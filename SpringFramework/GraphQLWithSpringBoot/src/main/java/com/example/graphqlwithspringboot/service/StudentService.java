package com.example.graphqlwithspringboot.service;

import com.example.graphqlwithspringboot.dto.request.CreateStudentRequest;
import com.example.graphqlwithspringboot.dto.request.CreateSubjectRequest;
import com.example.graphqlwithspringboot.entity.Address;
import com.example.graphqlwithspringboot.entity.Subject;
import com.example.graphqlwithspringboot.repository.AddressRepository;
import com.example.graphqlwithspringboot.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.graphqlwithspringboot.entity.Student;
import com.example.graphqlwithspringboot.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	SubjectRepository subjectRepository;

	@Autowired
	StudentRepository studentRepository;
	
	public Student getStudentById (long id) {
		return studentRepository.findById(id).get();
	}

	public Student createStudent (CreateStudentRequest createStudentRequest) {
		Student student = new Student(createStudentRequest);

		Address address = new Address();
		address.setStreet(createStudentRequest.getStreet());
		address.setCity(createStudentRequest.getCity());

		address = addressRepository.save(address);

		student.setAddress(address);
		student = studentRepository.save(student);

		List<Subject> subjectsList = new ArrayList<Subject>();

		if(createStudentRequest.getSubjectsLearning() != null) {
			for (CreateSubjectRequest createSubjectRequest :
					createStudentRequest.getSubjectsLearning()) {
				Subject subject = new Subject();
				subject.setSubjectName(createSubjectRequest.getSubjectName());
				subject.setMarksObtained(createSubjectRequest.getMarksObtained());
				subject.setStudent(student);

				subjectsList.add(subject);
			}

			subjectRepository.saveAll(subjectsList);

		}

		student.setLearningSubjects(subjectsList);

		return student;
	}
}
