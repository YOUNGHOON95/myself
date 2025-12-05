package com.one.study.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateMemberDto {
    private String name;
    private String title;
    private String contact;

    @Builder
    public UpdateMemberDto(String name, String title, String contact){
        this.name = name;
        this.title = title;
        this.contact = contact;
    }

}
