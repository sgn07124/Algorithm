package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller  // 클래스 파일이므로 이게 스프링이 알 수 있도록 @Controller를 추가하여 정형화 시켜야한다.
public class MemberController {
    private final MemberService memberService;

    @Autowired  // helloController과 memberService를 연결
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
