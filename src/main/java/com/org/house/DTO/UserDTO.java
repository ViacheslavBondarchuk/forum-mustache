package com.org.house.DTO;

import com.org.house.role.Role;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Date;

@Data
public class UserDTO {
    private int id;
    @Null
    private Date date;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private boolean isEnabled;
    private boolean isAccountNonLocked;
    private boolean isAccountNonExpired;
    private boolean isCredentialsNonExpired;
    private Collection<Role> authorities;
}
