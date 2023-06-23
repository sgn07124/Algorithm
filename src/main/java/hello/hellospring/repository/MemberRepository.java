package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);  // save: 회원이 저장소에 저장
    Optional<Member> findById(Long id);  // Optional : 값을 반환할 때 null 일 수 있어 이를 처리해주는 java 방식
    Optional<Member> findByName(String name);
    List<Member> findAll(); //지금까지 반환된 모든 회원 리스트를 모두 반환
}
