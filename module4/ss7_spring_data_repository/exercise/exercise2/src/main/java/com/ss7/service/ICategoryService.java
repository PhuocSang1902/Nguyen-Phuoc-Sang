package com.ss7.service;

import com.ss7.model.Category;

import java.util.List;

public interface ICategoryService extends IGeneralService<Category> {
    List<Category> findByName(String search);
}
