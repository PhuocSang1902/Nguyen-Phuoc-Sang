package com.test_final_module_4.service;

import com.test_final_module_4.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IQuestionContentService {
    Page<QuestionContent> findAll(Pageable pageable);

    void deleteById(Integer id);

    void save(QuestionContent questionContent);

    Optional<QuestionContent> findById(Integer id);

    Page<QuestionContent> findQuestion(String questionContent, int questionTypeId, Pageable pageable);
}
