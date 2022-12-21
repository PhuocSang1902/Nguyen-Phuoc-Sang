package com.test_final_module_4.service.impl;

import com.test_final_module_4.model.QuestionType;
import com.test_final_module_4.repository.IQuestionTypeRepository;
import com.test_final_module_4.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeService implements IQuestionTypeService {
    @Autowired
    IQuestionTypeRepository questionTypeRepository;

    @Override
    public List<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }
}
