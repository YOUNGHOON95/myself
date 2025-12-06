package com.one.study.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberDto {
    private Long id;
    private String name;
    private String password;
    private String title;
    private String email;
    private String contact;

    @Builder
    public MemberDto(Long id, String name, String password, String title, String email, String contact ) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.title = title;
        this.email = email;
        this.contact = contact;
    }


}
