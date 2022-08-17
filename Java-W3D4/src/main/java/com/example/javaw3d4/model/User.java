package com.example.javaw3d4.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class User implements UserDetails {

    @NotEmpty(message = "Id must not be empty!")
    @Id
    private String id;

    @NotEmpty(message = "Username must not be empty!")
    @Column(columnDefinition = "varchar(10) unique not null")
    private String username;

    @NotEmpty(message = "Password must not be empty!")
    @Column(columnDefinition = "varchar(32) not null")
    private String password;

    @NotEmpty(message = "Email must not be empty!")
    @Email
    @Column(columnDefinition = "varchar(32) unique not null")
    private String email;

    @NotEmpty(message = "Role must not be empty!")
    @Column(columnDefinition = "varchar(10) not null check (role='admin' or role='user')")
    private String role;

    //@NotEmpty(message = "Joining year must not be empty!")
    private LocalDate joiningYear;

    @NotNull(message = "Age should not be null!")
    @Column(columnDefinition = "Integer not null")
    private Integer age;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
