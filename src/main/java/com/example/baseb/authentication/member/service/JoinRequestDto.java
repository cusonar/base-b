package com.example.baseb.authentication.member.service;

import com.example.baseb.authentication.authority.Authority;
import com.example.baseb.authentication.member.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
public class JoinRequestDto {

    private String id;
    private String password;

    public Member toEntity() {
        return Member.builder()
                .id(id)
                .password(password)
                .authorities(Set.of(new Authority("ADMIN"), new Authority("USER")))
                .build();
    }
}
