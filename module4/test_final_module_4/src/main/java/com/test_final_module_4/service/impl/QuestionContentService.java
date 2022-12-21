package com.test_final_module_4.service.impl;

import com.test_final_module_4.model.QuestionContent;
import com.test_final_module_4.model.QuestionType;
import com.test_final_module_4.repository.IQuestionContentRepository;
import com.test_final_module_4.repository.IQuestionTypeRepository;
import com.test_final_module_4.service.IQuestionContentService;
import com.test_final_module_4.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionContentService implements IQuestionContentService {
    @Autowired
    IQuestionContentRepository questionContentRepository;
    @Autowired
    IQuestionTypeRepository questionTypeRepository;

    @Override
    public Page<QuestionContent> findAll(Pageable pageable) {
        return questionContentRepository.findAll(pageable);
    }

    @Override
    public void deleteById(Integer id) {
        questionContentRepository.deleteById(id);
    }

    @Override
    public void save(QuestionContent questionContent) {
        questionContentRepository.save(questionContent);
    }

    @Override
    public Optional<QuestionContent> findById(Integer id) {
        return questionContentRepository.findById(id);
    }

    @Override
    public Page<QuestionContent> findQuestion(String questionContent, int questionTypeId, Pageable pageable) {
        Optional<QuestionType> questionType = questionTypeRepository.findById(questionTypeId);
        if (questionTypeId != -1 && questionType.isPresent()){

            return questionContentRepository.findByTitleContainingAndAndQuestionType(questionContent,questionType.get(), pageable);
        }
        return questionContentRepository.findByTitleContainingOrderByStatus(questionContent, pageable);
    }
}
