package com.backend.repository;

import com.backend.entity.security.Role;
import com.backend.entity.security.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(RoleName name);

}
