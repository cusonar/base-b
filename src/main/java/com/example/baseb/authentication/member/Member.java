package com.example.baseb.authentication.member;

import com.example.baseb.authentication.authority.Authority;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Set;

@Getter
@Entity
@Table(name = "member")
@NoArgsConstructor
public class Member implements UserDetails {

    @Id
    @Column(name = "member_id")
    private String id;
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Set<Authority> authorities;
    private boolean isEnabled;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;

    @Builder
    public Member(String id, String password, Set<Authority> authorities) {
        this.id = id;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public String getUsername() {
        return id;
    }
}
