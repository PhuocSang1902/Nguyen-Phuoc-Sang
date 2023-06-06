package com.exercise_extra.service.impl;

import com.exercise_extra.repository.IPhimRepository;
import com.exercise_extra.service.IPhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhimService implements IPhimService {
    @Autowired
    IPhimRepository phimRepository;
}
