package com.one.study.controller;

import com.one.study.user.MemberDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class InsertData {
    @Setter
    @Getter
    public static class insertRequest {
        @Schema(description = "이름", example = "홍길동")
        @NotBlank(message = "빈칸없이 입력해주세요")
        private String name;

        @Schema(description = "패스워드", example = "패스워드 테스트")
        @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[!@#$%^&*()-+=]).{8,}$", message = "비밀번호는 8자 이상이어야 하며, 숫자/소문자/특수문자를 모두 포함해야 합니다")
        private String password;

        @Schema(description = "제목", example = "제목 테스트")
        private String title;

        @Schema(description = "이메일", example = "이메일 테스트")
        @Email(message = "이메일 형식을 확인해주세요")
        private String email;

        @Schema(description = "내용", example = "내용 테스트")
        private String contact;

        public insertRequest(){

        }

        @Builder
        public insertRequest(String name, String password, String title, String email, String contact) {
            this.name = name;
            this.password = password;
            this.title = title;
            this.email = email;
            this.contact = contact;
        }

        public MemberDto toParam(){
            return MemberDto.builder()
                    .name(name)
                    .password(password)
                    .title(title)
                    .email(email)
                    .contact(contact)
                    .build();
        }

    }

    @Getter
    public static class insertResponse {
        private String name;
        private String password;
        private String title;
        private String email;
        private String contact;

        @Builder
        public insertResponse(String name, String password, String title, String email, String contact){
            this.name = name;
            this.password = password;
            this.title = title;
            this.email = email;
            this.contact = contact;
        }

        public static insertResponse from(MemberDto memberdto){
            return insertResponse.builder()
                    .name(memberdto.getName())
                    .password(memberdto.getPassword())
                    .title(memberdto.getTitle())
                    .email(memberdto.getEmail())
                    .contact(memberdto.getContact())
                    .build();
        }


    }


}
