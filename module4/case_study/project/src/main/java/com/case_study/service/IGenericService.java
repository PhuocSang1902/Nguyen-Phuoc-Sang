package com.case_study.service;

import com.case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGenericService<T> {

    Optional<T> findById(Integer id);

    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);
}
