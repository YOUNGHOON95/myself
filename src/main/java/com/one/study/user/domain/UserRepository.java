package com.one.study.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Member, Long> {

    List<Member> findByName(String name);

    // name LIKE %name%
    List<Member> findByNameContaining(String name);

    //테스트 코드 마무리
    //전체 유저 검색하는데 조건검색 가능하게
    //(ex이메일이 뭐인 , 이름이 뭐인. 제목이 뭐인,)
    //이메일을 검색해서 나오는 정보
    //Like이니까 ID검색하는거랑 같은 원리인걸...


}
