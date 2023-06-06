package com.example.baseb.authentication.member;

import com.example.baseb.authentication.authority.Authority;
import lombok.Getter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Set;

@Getter
@Entity
@Table(name = "member")
public class Member implements UserDetails {

    @Id
    private String username;
    private String password;
    @OneToMany
    @JoinColumn(name = "username")
    private Set<Authority> authorities;
    private boolean isEnabled;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
}
