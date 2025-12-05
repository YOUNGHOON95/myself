package com.one.study.controller;

import com.one.study.user.InsertMemberDto;
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
        @NotBlank
        private String name;

        @Schema(description = "패스워드", example = "패스워드 테스트")
        @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[!@#$%^&*()-+=]).{8,}$")
        private String password;

        @Schema(description = "제목", example = "제목 테스트")
        private String title;

        @Schema(description = "이메일", example = "이메일 테스트")
        @Email
        private String email;

        @Schema(description = "내용", example = "내용 테스트")
        private String contact;

        @Builder
        public insertRequest(String name, String password, String title, String email, String contact) {
            this.name = name;
            this.password = password;
            this.title = title;
            this.email = email;
            this.contact = contact;
        }

        public InsertMemberDto toParam(){
            return InsertMemberDto.builder()
                    .name(name)
                    .password(password)
                    .title(title)
                    .email(email)
                    .contact(contact)
                    .build();
        }

    }

    public static class insertResponse {

    }


}
