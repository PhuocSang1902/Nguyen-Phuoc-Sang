package com.customermanegement.practice1.service;

import com.customermanegement.practice1.model.Province;

import java.util.Optional;

public interface IProvinceService {
    Iterable<Province> findAll();
    Optional<Province> findById(Integer id);
    void save(Province province);
    void remove(Integer id);
}
