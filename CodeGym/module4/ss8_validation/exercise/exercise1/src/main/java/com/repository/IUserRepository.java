package com.repository;

import com.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<MyUser, Integer> {
}
