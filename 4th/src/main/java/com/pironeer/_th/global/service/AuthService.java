package com.pironeer._th.global.service;


import com.pironeer._th.global.dto.response.JwtTokenSet;
import com.pironeer._th.global.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtUtil jwtUtil;

    public JwtTokenSet generateToken(Long userIdx) {
        String token = jwtUtil.createToken(userIdx);

        return JwtTokenSet.builder()
                .token(token)
                .build();

    }
}
