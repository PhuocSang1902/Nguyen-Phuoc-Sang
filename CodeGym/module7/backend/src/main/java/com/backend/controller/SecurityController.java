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
    public ResponseEntity<?> register(@Valid @RequestBody CustomerDto customerDto,
                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.BAD_REQUEST);
        }
//        if (accountService.existsByEmail(customerDto.getEmail())) {
//            return new ResponseEntity<>(new ResponseMessage("Email đã được đăng ký."), HttpStatus.CONFLICT);
//        }
        if (!accountService.existsByEmail(customerDto.getEmail())) {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            Account account = new Account();
            account.setName(customerDto.getName());
            account.setEmail(customerDto.getEmail());
            if (customerDto.getAvatar() == null || customerDto.getAvatar().trim().isEmpty()) {
                account.setAvatar("https://scontent.fdad1-2.fna.fbcdn.net/v/t39.30808-6/192275406_2914709508745440_8981882595411494044_n.jpg?_nc_cat=106&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=9zAXeOiPSG0AX--Zoj9&_nc_ht=scontent.fdad1-2.fna&oh=00_AfCWcgq7aOxNzbyKJGkuzqVSUGoLykco7Mv8XThFV22ElA&oe=63F5DC03");
            }
            account.setEncryptPassword(passwordEncoder.encode(customerDto.getEncryptPassword()));
            Set<Role> roles = new HashSet<>();
            Role customerRole = roleService.findByName(RoleName.ROLE_USER).orElse(new Role());
            roles.add(customerRole);
            account.setRoles(roles);
            accountService.save(account);
            customer.setAccount(account);
            customerService.save(customer);
//            sendMail.SendEmailToCustomer(customerDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getEmail(), signInForm.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.createToken(authentication);
        AccountPrinciple accountPrinciple = (AccountPrinciple) authentication.getPrincipal();
        Optional<Customer> customer = customerService.findByIdAccount(accountPrinciple.getId());
        if (customer.isPresent()) {
            return ResponseEntity.ok(new JwtResponse(token,
                    accountPrinciple.getName(),
                    accountPrinciple.getAuthorities(),
                    accountPrinciple.getId(),
                    accountPrinciple.getEmail(),
                    accountPrinciple.getAvatar(),
                    customer.get().getId()));
        }
        return ResponseEntity.ok(new JwtResponse(token,
                accountPrinciple.getName(),
                accountPrinciple.getAuthorities(),
                accountPrinciple.getId(),
                accountPrinciple.getEmail(),
                accountPrinciple.getAvatar()));
    }
}
