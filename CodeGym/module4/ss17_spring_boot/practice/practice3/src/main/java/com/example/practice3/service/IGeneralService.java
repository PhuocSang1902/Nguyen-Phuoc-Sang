package com.example.practice3.service;

import com.example.practice3.model.Customer;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<E> {
    Iterable<E> findAll();

    Optional<E> findById(Integer id);

    void save(E e);

    void remove(Integer id);

    List<Customer> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);
}
