package com.example.demo.controller;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
/**
 * @description
 * @author Tim Lin
 * @create 2018-07-01
 **/
@Controller

public class MemberController {


    @Autowired
    private MemberService memberService;

/*
    @RequestMapping(value = "/注册界面.html",method = RequestMethod.GET)
    public String insert(@ModelAttribute("member") Member member,Model model){
        System.out.println("hei");
        memberService.insert(member);
        return "redirect:/主界面.html";
    }
*/
    //更新信息
    /*
    @RequestMapping(value = "/stu/update",method = RequestMethod.GET)
    public String update(Model model){
        List<Student> list = studentService.getAllStudent();
//        request.setAttribute("students",list);
        return "student.html";
    }
    */
    //提交到页面

    @RequestMapping(value = "/注册界面.html",method = RequestMethod.GET)
    public String indexMember(Model model){
        model.addAttribute("member",new Member());
        return "注册界面.html";
    }

    //主页
    /*
    @RequestMapping(value = "/注册界面.html",method = RequestMethod.GET)
    public String index(Model model){
        return "注册界面.html";
    }
    */

    @RequestMapping("/index")
    public String  index(){
        return "主界面.html";
    }

    @RequestMapping("/登录后界面-信息维护.html")
    public String  imfoMaintain(){
        return "登录后界面-信息维护.html";
    }

    @RequestMapping("/登录后界面-提案查询-写者.html")
    public String  proposalWriter(){
        return "登录后界面-提案查询-写者.html";
    }

    @RequestMapping("/登录后界面-提案查询-管理.html")
    public String  proposalManage(){
        return "登录后界面-提案查询-管理.html";
    }

    @RequestMapping("/登录后界面-提案编制.html")
    public String  proposalMake(){
        return "登录后界面-提案编制.html";
    }

    @RequestMapping("/登录后界面-提案详情.html")
    public String  proposalDetail(){
        return "登录后界面-提案详情.html";
    }

    @RequestMapping("/主界面.html")
    public String  index2(){
        return "主界面.html";
    }


}
