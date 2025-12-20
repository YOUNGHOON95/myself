package com.one.study.controller;

import com.one.study.user.MemberDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
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
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "로그인 성공",
                    content = @Content(schema = @Schema(implementation = InsertData.insertResponse.class))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "서버 내부 오류")
    })
    public InsertData.insertResponse creatMember(@RequestBody @Valid InsertData.insertRequest insert){
        var bb = userService.saveMember(insert.toParam());

        return InsertData.insertResponse.from(bb);
        //return userService.saveMember(insert.toParam());
    }

    //SELECT 전체
    
    //SELECT 조건
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
    public UpdateData.Response updateMember(@PathVariable("id") Long id, @RequestBody UpdateData.updateRequest request) {
        var aa = userService.updateMember(id,request.toParam());
        //MemberDto aa = userService.updateMember(id,request.toParam());

        //return UpdateData.Response.from(userService.updateMember(id,request.toParam()));
        return UpdateData.Response.from(aa);

    }


    //DELETE
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "회원 삭제" , description = "회원 삭제 메서드")
    @Parameter(name = "id" , required = true , description = "아이디")
    public void deleteMember(@PathVariable("id") Long id) {
        userService.deleteMember(id);
    }

}
