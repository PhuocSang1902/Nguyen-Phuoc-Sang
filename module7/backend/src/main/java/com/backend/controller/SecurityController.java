package com.backend.controller;

import com.backend.dto.cart.CartTotal;
import com.backend.dto.customer.CustomerDto;
import com.backend.dto.security.JwtResponse;
import com.backend.dto.security.SignInForm;
import com.backend.entity.customer.Customer;
import com.backend.entity.security.Account;
import com.backend.entity.security.Role;
import com.backend.entity.security.RoleName;
import com.backend.jwt.jwt.JwtProvider;
import com.backend.jwt.jwt.JwtTokenFilter;
import com.backend.jwt.userprincal.AccountPrinciple;
import com.backend.service.cart.ICartService;
import com.backend.service.customer.ICustomerService;
import com.backend.service.security.IRoleService;
import com.backend.service.security.impl.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("api/public")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SecurityController {

    @Autowired
    AccountService accountService;

    @Autowired
    IRoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    JwtTokenFilter jwtTokenFilter;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private ICartService cartService;

    @PostMapping(value = "/signup")
    public ResponseEntity<Customer> register(@Valid @RequestBody CustomerDto customerDto,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<Customer>((Customer) bindingResult.getFieldErrors(),
                    HttpStatus.BAD_REQUEST);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        Account account = new Account();
        account.setName(customerDto.getName());
        account.setEmail(customerDto.getEmail());
        if (customerDto.getAvatar()==null){
            account.setAvatar("https://w7.pngwing.com/pngs/205/731/png-transparent-default-avatar-thumbnail.png");
        }else {
            account.setAvatar(customerDto.getAvatar());
        }
        account.setEncryptPassword(passwordEncoder.encode(customerDto.getEncryptPassword()));
        Set<Role> roles = new   HashSet<>();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("phuocsang1902@gmail.com");
        message.setTo(customerDto.getEmail());
        String mailSubject = "Đã gửi một email đến " + customerDto.getEmail();
        String mailContent = "Người gửi: " + "Tri Thức Shop" + "\n";
        mailContent += "Sender E-mail: " + "phuocsang1902@gmail.com" + "\n";
        mailContent += "Subject: " + "Thư phản hồi đăng ký" + "\n";
        mailContent += "Content: " + "Chào mừng bạn đến với Tri Thức Shop" + "\n";
        mailContent += "Username: " + customerDto.getEmail() + "\n";
        mailContent += "Password: " + customerDto.getEncryptPassword() + "\n";
        mailContent += "Content: " + "Vui lòng đăng nhập để tiếp tục." + "\n";
        message.setSubject(mailSubject);
        message.setText(mailContent);
        javaMailSender.send(message);
        Role customerRole = roleService.findByName(RoleName.ROLE_USER).orElse(new Role());
        roles.add(customerRole);
        account.setRoles(roles);
        accountService.save(account);
        customer.setAccount(account);
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getEmail(), signInForm.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.createToken(authentication);
        AccountPrinciple accountPrinciple = (AccountPrinciple) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(token,
                accountPrinciple.getName(),
                accountPrinciple.getAuthorities(),
                accountPrinciple.getId(),
                accountPrinciple.getEmail(),
                accountPrinciple.getAvatar()));
    }
}
