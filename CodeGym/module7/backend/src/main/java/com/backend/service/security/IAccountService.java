package com.backend.service.security;

import com.backend.entity.security.Account;

import java.util.Optional;

public interface IAccountService {
    Optional<Account> findByEmail(String email);

    Boolean existsByEmail(String email);

    Account save(Account account);
}
