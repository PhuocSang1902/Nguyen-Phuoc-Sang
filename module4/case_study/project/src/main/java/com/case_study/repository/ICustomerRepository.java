package com.case_study.repository;

import com.case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findByNameContaining(String name, Pageable pageable);
    @Query(value = "select * from customer where flag_remove=true" ,nativeQuery = true)
    Page<Customer> findAllByFlag(Pageable pageable);

    @Query(value = "update customer c set c.flagRemove = false where c.id = :id", nativeQuery = true)
    void remove(@Param("id")Integer id);
}
