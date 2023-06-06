package com.example.baseb.authentication.authority;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "authority")
public class Authority implements GrantedAuthority {

    @Id
    @Column(name = "authority_id")
    private Long id;
    private String authority;
}
