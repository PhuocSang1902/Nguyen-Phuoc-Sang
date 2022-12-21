package com.exercise_extra.service.impl;

import com.exercise_extra.repository.ISuatChieuRepository;
import com.exercise_extra.service.ISuatChieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuatChieuService implements ISuatChieuService {
    @Autowired
    ISuatChieuRepository suatChieuRepository;
}
