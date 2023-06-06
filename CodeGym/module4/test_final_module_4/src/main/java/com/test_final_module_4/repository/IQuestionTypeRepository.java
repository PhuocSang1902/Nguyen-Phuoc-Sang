package com.test_final_module_4.repository;

import com.test_final_module_4.model.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionTypeRepository extends JpaRepository<QuestionType, Integer> {
}
