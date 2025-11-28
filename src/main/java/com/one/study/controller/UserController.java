package com.one.study.controller;

import com.one.study.dto.MemberDto;
import com.one.study.dto.UpdateMemberDto;
import com.one.study.user.domain.Member;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.one.study.user.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    //INSERT
    @PostMapping()
    @Operation(summary = "회원 등록" , description = "회원 등록 메서드")
    public MemberDto creatMember(
                            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                            description = "회원 단건 등록",
                            required = true,
                            content = @Content(schema = @Schema(implementation = Member.class))
                    )
                    @RequestBody MemberDto memberdto){

            return userService.saveMember(memberdto);
    }

    //SELECT
    @GetMapping("/select/{id}")
    @Operation(summary = "회원 조회" , description = "회원 조회 메서드")
    @Parameter(name = "id" , required = true , description = "아이디")
    public MemberDto getMember(@PathVariable("id") Long id){
        return userService.getMember(id);
    }

    //UPDATE
    @PutMapping("/update/{id}")
    @Operation(summary = "회원 수정" , description = "회원 수정 메서드")
    @Parameter(name = "id" , required = true , description = "아이디")
    public Member updateMember(@PathVariable("id") Long id, @RequestBody UpdateMemberDto updatememberdto) {
        return userService.updateMember(id,updatememberdto);
    }


    //DELETE
    @GetMapping("/delete/{id}")
    @Operation(summary = "회원 삭제" , description = "회원 삭제 메서드")
    @Parameter(name = "id" , required = true , description = "아이디")
    public void deleteMember(@PathVariable("id") Long id) {
        userService.deleteMember(id);
    }

}
