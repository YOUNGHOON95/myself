package com.one.study.user;

import com.one.study.error.CommonException;
import com.one.study.error.ErrorCode;
import com.one.study.user.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.one.study.user.domain.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // INSERT
    public MemberDto saveMember(MemberDto insertmemberdto) {

        Member member = Member.fromDto(insertmemberdto);
        Member savedMember = userRepository.save(member);
        return savedMember.toDto();
    }

    // SELECT
    public MemberDto getMember(Long id){
        Member member = userRepository.findById(id).orElseThrow(() -> new CommonException(ErrorCode.USER_NOT_FOUND));

        return member.toDto();
    }

    // UPDATE
    public MemberDto updateMember(Long id, UpdateMemberDto updatememberdto) {
        Member member = userRepository.findById(id).orElseThrow();

        member.setName(updatememberdto.getName());
        member.setTitle(updatememberdto.getTitle());
        member.setContact(updatememberdto.getContact());
        
        return userRepository.save(member).toDto();
    }

    //DELETE
    public void deleteMember(Long id) {
        userRepository.deleteById(id);
    }


}
