package com.one.study.user;

import com.one.study.user.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.one.study.user.domain.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //INSERT
    public MemberDto saveMember(MemberDto insertmemberdto) {
        Member member = Member.fromDto(insertmemberdto);
        Member savedMember = userRepository.save(member);
        return savedMember.toDto();
    }

    //SELET
    public MemberDto getMember(Long id){
        Member member = userRepository.findById(id).orElseThrow();

        return member.toDto();
    }

    //UPDATE
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

//    public Member createMember(Member member){
//        return userRepository.save(member);
//    }

//    public Optional<Member> findByid(Long id){
//        return userRepository.findById(id);
//    }


}
