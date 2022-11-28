package com.customermanegement.practice1.repository;

import com.customermanegement.practice1.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
}
