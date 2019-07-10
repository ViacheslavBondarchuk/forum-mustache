package com.org.house.dto;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;
import java.util.Date;

@Data
public class UserDTO {
    @Null
    private int id;
    @Null
    private Date date;
    @Email
    @NonNull
    @NotEmpty
    private String email;
    @NonNull
    @NotEmpty
    private String firstName;
    @NonNull
    @NotEmpty
    private String lastName;
    @NonNull
    @NotEmpty
    private String username;
    @NonNull
    @NotEmpty
    private String password;
    private boolean isEnabled;
    private boolean isAccountNonLocked;
    private boolean isAccountNonExpired;
    private boolean isCredentialsNonExpired;
}
