package com.exercise.finish_project.repository;

import com.exercise.finish_project.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
