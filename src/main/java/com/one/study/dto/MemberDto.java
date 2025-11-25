package com.one.study.dto;

import com.one.study.user.domain.Member;
import lombok.Getter;

@Getter
public class MemberDto {
    private Long id;
    private String name;
    private String password;
    private String title;
    private String email;
    private String contact;

    public MemberDto(Member member){
        this.id = member.getId();
        this.name = member.getName();
        this.password = member.getPassword();
        this.title = member.getTitle();
        this.email = member.getEmail();
        this.contact = member.getContact();
    }

    public static MemberDto from(Member member){
        return new MemberDto(member);
    }

}
