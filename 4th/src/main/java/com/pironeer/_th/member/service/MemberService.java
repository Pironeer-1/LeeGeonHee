package com.pironeer._th.member.service;

import com.pironeer._th.global.dto.response.JwtTokenSet;
import com.pironeer._th.global.dto.response.result.SingleResult;
import com.pironeer._th.global.exception.CustomException;
import com.pironeer._th.global.exception.ErrorCode;
import com.pironeer._th.global.service.AuthService;
import com.pironeer._th.global.service.ResponseService;
import com.pironeer._th.member.dto.request.MemberCreateRequest;
import com.pironeer._th.member.dto.request.MemberLoginRequest;
import com.pironeer._th.member.entity.Member;
import com.pironeer._th.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final AuthService authService;

    public SingleResult<JwtTokenSet> register(MemberCreateRequest request) {
        if (memberRepository.existByMemberId(request.memberId())) {
            throw new CustomException(ErrorCode.USER_ALREADY_EXIST);
        }
        Member newMember = Member.builder()
                .memberId(request.memberId())
                .password(request.password())
                .name(request.name())
                .build();

        newMember = memberRepository.save(newMember);

        JwtTokenSet jwtTokenSet = authService.generateToken(newMember.getId());

        return ResponseService.getSingleResult(jwtTokenSet);
    }

    public SingleResult<JwtTokenSet> login(MemberLoginRequest request) {
        Member member = memberRepository.findByMemberId(request.memberId())
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_EXIST));

        if (!member.getPassword().equals(request.password())) {
            throw new CustomException(ErrorCode.USER_WRONG_PASSWORD);
        }

        JwtTokenSet jwtTokenSet = authService.generateToken(member.getId());

        return ResponseService.getSingleResult(jwtTokenSet);
    }
}
