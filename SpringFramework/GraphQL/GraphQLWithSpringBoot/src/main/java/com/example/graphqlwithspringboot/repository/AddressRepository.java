package com.example.graphqlwithspringboot.repository;

import com.example.graphqlwithspringboot.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
