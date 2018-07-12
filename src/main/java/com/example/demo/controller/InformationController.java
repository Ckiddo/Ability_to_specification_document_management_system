package com.example.demo.controller;

import com.example.demo.entity.Information;
<<<<<<< HEAD
import com.example.demo.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
=======
import com.example.demo.entity.Member;
import com.example.demo.service.InformationService;
import com.example.demo.service.MemberService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
>>>>>>> wpf2
import java.util.List;

@Controller
public class InformationController {

    @Autowired
<<<<<<< HEAD
    private InformationService informationService;

    @RequestMapping(value = "",method = RequestMethod.GET)
=======
    private MemberService memberService;

    @Autowired
    private InformationService informationService;

    @RequestMapping(value = "/getinformation",method = RequestMethod.GET)
>>>>>>> wpf2
    public String getAllInformation(HttpServletRequest request){
        List<Information> list = informationService.getAllInformation();
        request.setAttribute("",list);
        return "";
    }
<<<<<<< HEAD
}
=======



    @RequestMapping(value = "getallmember",method = RequestMethod.GET)
    public String getAllStandard(HttpServletRequest request){
        List<Member> member1 = memberService.getAllMember();
        List<Member> member=new ArrayList();
        for(Member s:member1){
            if(s.getUsergroup()==0)
                member.add(s);
        }
        request.setAttribute("member",member);
        return "m_identity_manage.html";
    }



    @RequestMapping(value = "memberdetail", method = RequestMethod.GET)
    public String getonemember(@RequestParam("name") String name, Model model) {
        // request.setAttribute("comlist", list);
        Member member=new Member();
        member.setName(name);
        System.out.println(member);
        Member member1 = memberService.findaname(member);
        // List<Comment> list = commentService.getAllComment();
        System.out.println(member1);
        model.addAttribute("member1", member1);
        return "m_identity_manage_detail.html";
    }
}
>>>>>>> wpf2
