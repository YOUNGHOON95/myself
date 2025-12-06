package com.one.study.controller;

import com.one.study.user.MemberDto;
import com.one.study.user.UpdateMemberDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class UpdateData {
    @Setter
    @Getter
    public static class updateRequest {
        @Schema(description = "이름", example = "이름 테스트")
        @NotBlank
        private String name;

        @Schema(description = "제목", example = "제목 테스트")
        private String title;

        @Schema(description = "내용", example = "내용 테스트")
        private String contact;

        public updateRequest(){

        }

        @Builder
        public updateRequest(String name, String title, String contact){
            this.name = name;
            this.title = title;
            this.contact = contact;
        }

        public UpdateMemberDto toParam(){
            return UpdateMemberDto.builder()
                    .name(name)
                    .title(title)
                    .contact(contact)
                    .build();
        }

    }

    @Getter
    public static class Response {
        @Schema(description = "이름" , example = "홍길동")
        private String name;
        @Schema(description = "제목", example = "제목입니다")
        private String title;
        @Schema(description = "내용", example = "내용입니다")
        private String contact;

        @Builder
        public Response(String name, String title, String contact){
            this.name = name;
            this.title = title;
            this.contact = contact;
        }

        public static Response from(MemberDto memberdto) {
            return  Response.builder()
                    .name(memberdto.getName())
                    .title(memberdto.getTitle())
                    .contact(memberdto.getContact())
                    .build();
        }

    }

}
