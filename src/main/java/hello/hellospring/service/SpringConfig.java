package hello.hellospring.service;

import hello.hellospring.repository.*;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    /*
    private final DataSource dataSource;  // 1

    @Autowired  // 2
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    */
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();  // db가 정해지지 않은 경우
        // 아래의 문장 추가하고 위 1, 2 추가하면 됨
        //return new JdbcMemberRepository(dataSource);  // db가 정해져 연결
        //return new JdbcTemplateMemberRepository(dataSource);  // Jdbc 실행
        return new JpaMemberRepository(em);
    }
}
