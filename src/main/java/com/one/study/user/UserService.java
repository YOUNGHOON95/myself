package com.one.study.user;

import com.one.study.user.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.one.study.user.domain.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Member createMember(Member member){
        return userRepository.save(member);
    }

    public Optional<Member> findByid(Long id){
        return userRepository.findById(id);
    }


}
