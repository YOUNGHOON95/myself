package com.one.study.user;

import com.one.study.user.domain.Members;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.one.study.user.domain.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Members createMember(Members member){
        return userRepository.save(member);
    }

    public Optional<Members> findByid(Long id){
        return userRepository.findById(id);
    }


}
