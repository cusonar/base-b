package com.example.baseb.authentication.member.service;

import com.example.baseb.authentication.member.Member;
import com.example.baseb.authentication.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public String join(MemberJoinDto dto) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        Member member = dto.toEntity();
        Member savedMember = memberRepository.save(member);
        return savedMember.getId();
    }
}
