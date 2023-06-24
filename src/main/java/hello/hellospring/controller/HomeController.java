package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {  // controller을 먼저 찾기 때문에 index.html이 무시되고 HomeController.java가 실행되어 home.html이 열림

    @GetMapping("/")  // / : localhost:8080 들어온 상태. home.html 이 열림
    public String home() {
        return "home";
    }
}
