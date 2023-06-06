package com.backend.service.security;

import com.backend.entity.security.Role;
import com.backend.entity.security.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
