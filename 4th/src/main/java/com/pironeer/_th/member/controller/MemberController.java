package com.pironeer._th.member.controller;

import com.pironeer._th.board.dto.response.BoardResponse;
import com.pironeer._th.global.dto.response.JwtTokenSet;
import com.pironeer._th.global.dto.response.SuccessResponse;
import com.pironeer._th.global.dto.response.result.SingleResult;
import com.pironeer._th.member.dto.request.MemberCreateRequest;
import com.pironeer._th.member.dto.request.MemberLoginRequest;
import com.pironeer._th.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@Tag(name = "Member")
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    @Operation(summary = "회원가입")
    public SuccessResponse<SingleResult<JwtTokenSet>> register(@Valid @RequestBody MemberCreateRequest request) {
        SingleResult<JwtTokenSet> result = memberService.register(request);
        return SuccessResponse.ok(result);
    }

    @PostMapping("/login")
    @Operation(summary = "로그인")
    public SuccessResponse<SingleResult<JwtTokenSet>> login(@Valid @RequestBody MemberLoginRequest request) {
        SingleResult<JwtTokenSet> result = memberService.login(request);
        return SuccessResponse.ok(result);
    }
}
