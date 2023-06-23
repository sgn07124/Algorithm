package hello.hellospring.Repository;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {  // 굳이 public 으로 할 필요없어서 지움

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // findAll과 findByName에서 모두 똑같은 member1과 member2 객체가 둘 다 생성 되었기 때문에 실행 시 에러가 발생한다.
    // 이를 해결하깅 위해 메서드의 실행이 끝날 때마다 실행되는 @AfterEach 메서드에 만들어, 저장소의 내용들을 모두 삭제하는 작업을 한다.
    @AfterEach  // 메서드 실행이 끝날 때마다 실행됨
    public void afterEach() {
        repository.clearStore(); // 저장소 내용 다 지움
    }

    @Test
    // save 메서드가 정상적으로 작동이 되는지 확인
    public void save() {
        Member member = new Member();  // member 객체 만듦
        member.setName("spring");

        repository.save(member);  // 저장소에 객체 member 저장

        // member의 id 값으로, 저장소에 저장된 객체 result 가져옴
        // get(): 값을 꺼내옴
        Member result = repository.findById(member.getId()).get();

        // 저장한 member와 저장소에서 가져온 result가 같은 지 검증
        System.out.println("result = " + (result == member));
        //Assertions.assertEquals(member, result);  // junit.jupiter.api
        Assertions.assertThat(member).isEqualTo(result);  // assertj.core.api
    }

    @Test
    // findByName 메서드가 정상적으로 작동이 되는지 확인
    public void findByName() {
        Member member1 = new Member();  // member1 객체 만들어 저장소에 저장
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();  // member2 객체 만들어 저장소에 저장
        member2.setName("spring2");
        repository.save(member2);

        // member2의 이름으로, 저장소에 저장된 객체 가져옴
        Member result = repository.findByName("spring2").get();

        // member2과 저장소에서 가져온 result가 같은 지 검증. 다르면 error 발생
        Assertions.assertThat(result).isEqualTo(member2);

    }

    @Test
    public void findAll() {
        Member member1 = new Member();  // member1 객체 만들어 저장소에 저장
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();  // member2 객체 만들어 저장소에 저장
        member2.setName("spring2");
        repository.save(member2);

        Member member3 = new Member();  // member3 객체 만들어 저장소에 저장
        member3.setName("spring3");
        repository.save(member3);

        // 저장소에 저장된 객체를 List로 가져옴
        List<Member> result = repository.findAll();

        // 저장소에서 가져온 List의 size가 3와 같은 지 검증
        Assertions.assertThat(result.size()).isEqualTo(3);
    }
}
