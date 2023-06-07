package com.example.baseb.authentication.member;

import com.example.baseb.authentication.member.service.LoginDto;
import com.example.baseb.authentication.member.service.MemberJoinDto;
import com.example.baseb.authentication.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final AuthenticationProvider authenticationProvider;

    @PostMapping("join")
    String join(@RequestBody MemberJoinDto dto) {
        log.info("join request: {}", dto);
        String joinedId = memberService.join(dto);
        log.info("join complted: {}", joinedId);
        return joinedId;
    }

    @PostMapping("login")
    String login(@RequestBody LoginDto dto) {
        return null;
    }
}
