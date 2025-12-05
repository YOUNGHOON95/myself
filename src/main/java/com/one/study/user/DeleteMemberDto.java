package com.one.study.user;

import lombok.Builder;
import lombok.Getter;

@Getter
public class DeleteMemberDto {
    private Long id;

    @Builder
    public DeleteMemberDto(Long id){
        this.id = id;
    }

}
