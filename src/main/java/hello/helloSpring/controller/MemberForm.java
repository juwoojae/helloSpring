package hello.helloSpring.controller;

public class MemberForm {
    private String name;    //createMemberForm 에 있는 name 이랑 매칭이되서 온다

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
