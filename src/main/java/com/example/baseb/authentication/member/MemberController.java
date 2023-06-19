package com.example.baseb.authentication.member;

import com.example.baseb.authentication.member.service.*;
import com.example.baseb.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    @PostMapping("join")
    public JoinResponseDto join(@RequestBody JoinRequestDto dto) {
        log.info("join request: {}", dto);
        String joinedId = memberService.join(dto);
        log.info("join completed: {}", joinedId);
        return new JoinResponseDto(joinedId);
    }

    @PostMapping("login")
    public LoginResponseDto login(@RequestBody LoginRequestDto dto) throws Exception {
        authenticate(dto.getId(), dto.getPassword());
        Member member = (Member) memberService.loadUserByUsername(dto.getId());
        String token = jwtTokenUtil.generateToken(member);

        return new LoginResponseDto(token);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
