package com.example.demo.controller;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
/**
 * @description
 * @author Tim Lin
 * @create 2018-07-01
 **/
@Controller

public class  MemberController {

    public static HttpServletRequest getRequest(){
        ServletRequestAttributes attrs=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }
    public static HttpSession getSession(){
        HttpSession session=null;
        try{
            session =getRequest().getSession();
        }catch (Exception e){}
        return session;
    }


    @Autowired
    private MemberService memberService;


    @RequestMapping(value = "/insert",method = RequestMethod.GET)
    public String insert(@ModelAttribute("member") Member member,Model model){
        System.out.println("hei");

        if (memberService.findname(member)!=0)
            return"/register.html";
        else
        {memberService.insert(member);
            return "/login_menu.html";}
    }

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

    @RequestMapping(value = "/regist",method = RequestMethod.GET)
    public String indexMember(Model model){
        model.addAttribute("member",new Member());
        return "register.html";
}

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String getMember(@ModelAttribute("member") Member member,Model model,HttpServletRequest request) {
        System.out.println(memberService.findname(member));
        System.out.println("输入的名字" + member.getName());
        System.out.println("数据库的名字" + member.getPassword());
        if (memberService.findname(member) == 1 && memberService.getusergroup(member) == 0)/////增加审核后改为1
         {  HttpSession session = request.getSession();                     //
               session.setAttribute("member_name",member);            //
            return "w_func_choose.html";
            }
       else
           return "login_menu_error.html";
    }
    //主页
    /*
    @RequestMapping(value = "/注册界面.html",method = RequestMethod.GET)
    public String index(Model model){
        return "注册界面.html";
    }
    */

    @RequestMapping("/index")
    public String  index(Model model){
        System.out.println("nb了");
        model.addAttribute("member",new Member());
        return "login_menu.html";
    }

    @RequestMapping("/登录后界面-信息维护.html")
    public String  imfoMaintain(){
        return "登录后界面-信息维护.html";
    }

    @RequestMapping("/登录后界面-提案查询-写者.html")
    public String  proposalWriter(){
        return "写者-提案查询.html";
    }
/*
    @RequestMapping("/登录后界面-提案查询-管理.html")
    public String  proposalManage(){
        return "登录后界面-提案查询-管理.html";
    }
*/
    @RequestMapping("/登录后界面-提案编制.html")
    public String  proposalMake(){
        return "写者-提案编制.html";
    }

    @RequestMapping("/登录后界面-提案详情.html")
    public String  proposalDetail(){
        return "写者-提案详情.html";
    }

    @RequestMapping("login_menu")
    public String  index2(Model model){
        System.out.println("安排");
        model.addAttribute("member",new Member());
        return "login_menu.html";
    }


}
