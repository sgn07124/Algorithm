package hello.hellospring.controller;

public class MemberForm {
    private String name;  // createMemberForm.html에서 입력된 name이 들어옴

    public String getName() {
        return name;
    }

    public void setName(String name) {  // setName을 통해 값이 들어감(private 이므로)
        this.name = name;
    }
}
