package com.backend.jwt.userprincal;

import com.backend.entity.security.Account;
import com.backend.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountDetailService implements UserDetailsService {
    @Autowired
    IAccountRepository accountRepository;

    @Override// tìm account có tồn tại trong DB không
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email).orElseThrow(() -> new
                UsernameNotFoundException("Account không tìm thấy -> email hoặc passwword" + email));
        return AccountPrinciple.build(account); // gọi lại hàm build bên Accountprinciple để build account mới
    }
}
