package com.one.study.user;

import com.one.study.error.CommonException;
import com.one.study.error.ErrorCode;
import com.one.study.user.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.one.study.user.domain.UserRepository;

import java.util.List;

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
    public Page<MemberDto> getMembers(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(member -> member.toDto());
    }

    // SELECT ID
    public MemberDto getMember(Long id){
        Member member = userRepository.findById(id).orElseThrow(() -> new CommonException(ErrorCode.USER_NOT_FOUND));

        return member.toDto();
    }

    // SELECT NAME
    public List<MemberDto> getMemberName(String name){
        List<Member> members = userRepository.findByNameContaining(name);

        if (members.isEmpty()) {
            throw new CommonException(ErrorCode.USER_NOT_FOUND);
        }

        return members.stream()
                .map(Member -> Member.toDto())
                .toList();
    }

    // UPDATE
    public MemberDto updateMember(Long id, UpdateMemberDto updatememberdto) {
        Member member = userRepository.findById(id).orElseThrow();

        member.setName(updatememberdto.getName());
        member.setTitle(updatememberdto.getTitle());
        member.setContact(updatememberdto.getContact());
        
        return userRepository.save(member).toDto();
    }

    // DELETE
    public void deleteMember(Long id) {
        userRepository.deleteById(id);
    }


}
