package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller  // 클래스 파일이므로 이게 스프링이 알 수 있도록 @Controller를 추가하여 정형화 시켜야한다.
public class MemberController {
    private final MemberService memberService;

    @Autowired  // helloController과 memberService를 연결
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")  // 1. CreateMemberFomr.html에서 입력한 name이 post요청으로 여기로 넘어옴
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());  // member을 생성함

        System.out.println("member = " + member.getName());  //

        memberService.join(member);  // member을 넘김

        return "redirect:/"; // member를 서버에 저장하고 home 화면으로 넘어감
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();  // findMembers() : members를 모두 가져옴
        model.addAttribute("members", members);  // members list 전체를 model에 넘긴다.
        return "members/memberList";
    }
}
