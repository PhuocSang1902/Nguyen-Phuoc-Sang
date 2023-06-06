package com.backend.service.security.impl;

import com.backend.entity.security.Role;
import com.backend.entity.security.RoleName;
import com.backend.repository.IRoleRepository;
import com.backend.service.security.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleService implements IRoleService {
    @Autowired
    IRoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
