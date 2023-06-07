package com.example.baseb.authentication.authority;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "authority")
@NoArgsConstructor
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue
    @Column(name = "authority_id")
    private Long id;
    private String authority;

    public Authority(String authority) {
        this.authority = authority;
    }
}
