package com.ss7.service;

import org.springframework.stereotype.Service;

import java.util.Optional;

public interface IGeneralService <E> {

    Iterable<E> findAll();

    Optional<E> findById(Integer Id);

    void save(E e);

    void remove(Integer id);
}
