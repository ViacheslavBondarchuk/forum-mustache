package com.org.house.entity;

import com.org.house.role.Role;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Data
@Table( name = "users")
@Entity
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date date;
    @UniqueElements
    private String email;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private boolean isEnabled;
    private boolean isAccountNonLocked;
    private boolean isAccountNonExpired;
    private boolean isCredentialsNonExpired;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    private Collection<Role> authorities;

}
