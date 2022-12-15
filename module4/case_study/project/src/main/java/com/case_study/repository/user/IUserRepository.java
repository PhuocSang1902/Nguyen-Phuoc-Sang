package com.case_study.repository.user;

import com.case_study.model.user.UserEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEmployee, String> {
    UserEmployee findByUsername(String username);
}
