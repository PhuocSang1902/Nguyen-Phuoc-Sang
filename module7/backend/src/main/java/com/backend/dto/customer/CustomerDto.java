package com.backend.dto.customer;

import com.backend.entity.security.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Integer id;
    @NotBlank(message = "Không được để trống.")
    private String name;
    @NotBlank(message = "Không được để trống.")
    private String email;
    @NotBlank(message = "Không được để trống.")
    private String phone;
    @NotBlank(message = "Không được để trống.")
    private String address;
    @NotBlank(message = "Không được để trống.")
    private String birthday;
    private boolean gender;
    private String avatar;
    private String encryptPassword;
}
