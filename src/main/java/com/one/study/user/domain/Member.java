package com.one.study.user.domain;

import com.one.study.user.MemberDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String title;
    private String email;
    private String contact;


    //1번쨰
    @Builder
    public Member (Long id, String name, String password, String title, String email, String contact ) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.title = title;
        this.email = email;
        this.contact = contact;

    }


    //2번째
    public MemberDto toDto() {
        return new MemberDto(
                this.getId(),
                this.getName(),
                this.getPassword(),
                this.getTitle(),
                this.getEmail(),
                this.getContact()
        );
    }


    public static Member fromDto(MemberDto memberDto){
        return new Member(
                memberDto.getId(),
                memberDto.getName(),
                memberDto.getPassword(),
                memberDto.getTitle(),
                memberDto.getEmail(),
                memberDto.getContact()
        );
    }


}
