package com.one.study.controller;

import com.one.study.user.domain.Member;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.one.study.user.UserService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;
    
    @PostMapping()
    @Operation(summary = "회원 등록" , description = "회원 등록 메서드")
    public Member creatMember(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "회원 단건 등록",
                    required = true,
                    content = @Content(schema = @Schema(implementation = Member.class))
            )
            @RequestBody Member member){

        return userService.createMember(member);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "회원 조회" , description = "회원 조회 메서드")
    @Parameter(name = "id" , required = true , description = "아이디")
    public Optional<Member> getMember(@PathVariable("id") Long id){
        return userService.findByid(id);
    }
    
}
