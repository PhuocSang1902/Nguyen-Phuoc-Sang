package com.example.graphqlwithspringboot.repository;

import com.example.graphqlwithspringboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
