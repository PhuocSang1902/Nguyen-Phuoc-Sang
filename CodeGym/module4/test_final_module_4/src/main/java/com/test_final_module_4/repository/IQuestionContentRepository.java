package com.test_final_module_4.repository;

import com.test_final_module_4.model.QuestionContent;
import com.test_final_module_4.model.QuestionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionContentRepository extends JpaRepository<QuestionContent, Integer> {
    Page<QuestionContent> findByTitleContainingOrderByStatus(String questionContent, Pageable pageable);
    Page<QuestionContent> findByTitleContainingAndAndQuestionType(String questionContent, QuestionType questionTypeId, Pageable pageable);
}
