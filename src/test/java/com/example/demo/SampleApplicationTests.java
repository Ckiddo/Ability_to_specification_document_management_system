package com.example.demo;

<<<<<<< HEAD
import com.example.demo.service.impl.StudentServiceImpl;
=======
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
>>>>>>> wpf2
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleApplicationTests {
<<<<<<< HEAD
    static StudentServiceImpl ssi = new StudentServiceImpl();
    @Test
    static void contextLoads() {
        ssi.getAllStudent();
    }
    public static void main(String args[]){
        contextLoads();
=======

    @Autowired
    MemberService memberService;
    @Test
    public void contextLoads() {
        Member member=new Member();
        member.setName("wpf");
        memberService.updategroup("wpf");
        memberService.update(member);
        memberService.getusergroup(member);
        memberService.findaname(member);
        memberService.deletemember("123");
        memberService.getAllMember();



>>>>>>> wpf2
    }

}
