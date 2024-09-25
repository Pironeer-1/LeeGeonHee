package com.pironeer._th.global.service;


import com.pironeer._th.global.dto.response.JwtTokenSet;
import com.pironeer._th.global.jwt.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtUtil jwtUtil;

    public JwtTokenSet generateToken(Long userIdx) {
        String token = jwtUtil.createToken(userIdx);

        JwtTokenSet jwtTokenSet = JwtTokenSet.builder()
                .grantType("Bearer")
                .token(token)
                .build();

        return jwtTokenSet;
    }
}
