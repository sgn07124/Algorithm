package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;  // member service
    MemoryMemberRepository memberRepository;

    // MemberService에 memberRepository 를 외부에서 넣어주도록 한다. -> DI(Dependency Injection)
    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();  // member 객체 생성
        member.setName("hello");  // member name에 hello을 넣음

        //when
        // member 객체를 회원가입하고, 반환된 id를 saveId
        Long saveId = memberService.join(member);

        //then
        // 회원가입한 member의 id가 저장소에 있으면, 해당 member 객체를 findMember로
        Member findMember = memberService.findOne(saveId).get();
        // 회원가입한 member와, 저장소에서 가져온 member의 이름이 같은 지 검증
        org.assertj.core.api.Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        // 이름이 같은 중복 회원 member 객체 생성. 둘 다 "spring"으로 이름이 같음
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2)); // assertThrows(IllegalStateException.class 로직을 실행을 할건데 () -> memberService.join(member2) 예외가 터져야 함
        //assertThrows(NullPointerException.class, () -> memberService.join(member2));  // Test 실패

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        /* try-catch문을 사용할 경우
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.ㅇㄹ");  // 이 부분의 메시지가 다르게 입력되면 오류 발생함
        } // 그래서 위와 같은 문법 사용
        */

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}