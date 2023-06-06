package com.example.practice3.repository;

import com.example.practice3.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);
}
