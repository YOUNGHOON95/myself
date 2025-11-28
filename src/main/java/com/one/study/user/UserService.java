package com.one.study.user;

import com.one.study.dto.DeleteMemberDto;
import com.one.study.dto.MemberDto;
import com.one.study.dto.UpdateMemberDto;
import com.one.study.user.domain.Member;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.one.study.user.domain.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //INSERT
    public MemberDto saveMember(MemberDto memberdto) {
        Member member = Member.fromDto(memberdto);
        Member savedMember = userRepository.save(member);
        return savedMember.toDto();
    }

    //SELET
    public MemberDto getMember(Long id){
        Member member = userRepository.findById(id).orElseThrow();

        return member.toDto();
    }

    //UPDATE
    public Member updateMember(Long id, UpdateMemberDto updatememberdto) {
        Member updateMemberDto = userRepository.findById(id).orElseThrow();

        updatememberdto.setName(updatememberdto.getName());
        updateMemberDto.setTitle(updateMemberDto.getTitle());
        updatememberdto.setContact(updateMemberDto.getContact());
        
        return userRepository.save(updateMemberDto);
    }

    //DELETE
    public void deleteMember(Long id) {
        userRepository.deleteById(id);
    }

//    public Member createMember(Member member){
//        return userRepository.save(member);
//    }

//    public Optional<Member> findByid(Long id){
//        return userRepository.findById(id);
//    }


}
