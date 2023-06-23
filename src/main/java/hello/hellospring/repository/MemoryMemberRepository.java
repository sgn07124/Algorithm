package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    // Map: java의 데이터 저장 방식 중 하나
    // key: Long, value: Member
    private static Map<Long, Member> store = new HashMap<>();

    private static long sequence = 0L;  // sequence: key값을 생성해줌
    @Override
    public Member save(Member member) {  // save
        member.setId(++sequence);  // sequence값 증가(key값)
        store.put(member.getId(), member);  // store에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // null일 수 있어 Optional.ofNullable() 로 감쌈
        return Optional.ofNullable(store.get(id));  // id값으로 해당 객체 store에서 꺼내서 return
    }

    @Override
    public Optional<Member> findByName(String name) {  // findByName
        return store.values().stream()  // value값들을 루프를 돌아서
                .filter(member -> member.getName().equals(name))  // param로 넘어온 name과 같은 것을 filtering
                .findAny();  // 처음 filtering 된 요소 1개를 return
    }

    @Override
    public List<Member> findAll() {  // findAll
        return new ArrayList<>(store.values());  // 저장소에 있는 value들을 List로 반환
    }

    public void clearStore() {  // clearStore
        store.clear();  // 저장소 내용 지움
    }
}
