package com.case_study.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGenericService<T> {
    Page<T> findAllAndByName(String search, Pageable pageable);
    Optional<T> findById(Integer id);
    void remove(Integer id);
    void edit(Integer id);
}
