package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {

    // 저장소
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;

    }

    // 회원가입
    public long join(Member member) {
        // 같은 이름이 있는 중복 회원 x
        /*
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });  // 아래와 같이 간단하게 작성 가능
        */

        // 중복회원 검증 메서드 호출
        validateDuplicaterMember(member);

        // member를 저장소에 저장
        memberRepository.save(member);
        // member id 반환
        return member.getId();
    }

    // 중복회원 검증 메서드
    private void validateDuplicaterMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {  // 이름이 같은 회원이 존재하면
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // id로 회원 조회
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }


}
