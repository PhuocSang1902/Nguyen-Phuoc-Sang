package com.example.graphqlwithspringboot.repository;

import com.example.graphqlwithspringboot.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
