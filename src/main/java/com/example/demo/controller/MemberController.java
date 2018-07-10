package com.example.demo.controller;
import com.example.demo.dao.ProposalDAO;
import com.example.demo.entity.Member;
import com.example.demo.entity.Proposal;
import com.example.demo.entity.Standard;
import com.example.demo.service.MemberService;
import com.example.demo.service.ProposalService;
import com.example.demo.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }

    public static HttpSession getSession() {
        HttpSession session = null;
        try {
            session = getRequest().getSession();
        } catch (Exception e) {
        }
        return session;
    }


    @Autowired
    private MemberService memberService;
    @Autowired
    private StandardService standardService;
    @Autowired
    private ProposalService proposalService;

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert(@ModelAttribute("member") Member member, Model model) {
        System.out.println("hei");

        if (memberService.findname(member) != 0)
            return "/register.html";
        else {
            memberService.insert(member);
            return "redirect:/index";
        }
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

    @RequestMapping(value = "/regist", method = RequestMethod.GET)
    public String indexMember(Model model) {
        model.addAttribute("member", new Member());
        return "register.html";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String getMember(@ModelAttribute("member") Member member, Model model, HttpServletRequest request) {
        System.out.println(memberService.findname(member));
        System.out.println("输入的名字" + member.getName());
        System.out.println("数据库的名字" + member.getPassword());
        if (memberService.findname(member) == 1 && memberService.getusergroup(member) == 1)/////增加审核后改为1
        {
            HttpSession session = request.getSession();                     //
            session.setAttribute("member_name", member);            //
            return "w_func_choose.html";
        }

        if (memberService.findname(member) == 1 && memberService.getusergroup(member) > 1)//管理员
        {
            System.out.println("管理员登陆");
            HttpSession session = request.getSession();                     //
            session.setAttribute("member_name", member);            //
            return "m_func_choose.html";
        } else
            return "login_menu_error.html";
    }

    @RequestMapping(value = "w_func_choose.html", method = RequestMethod.GET)
    public String choice() {
        Member member = (Member) getSession().getAttribute("member_name");
        System.out.println(member);
        Member member1 = memberService.findaname(member);
        if (member1.getUsergroup() == 1)
            return "/w_func_choose.html";
        else
            return "/m_func_choose.html";
    }

    @RequestMapping(value = "enterapproval", method = RequestMethod.GET)
    public String choice3(HttpServletRequest request) {
        Member member = (Member) getSession().getAttribute("member_name");
        System.out.println(member);
        List<Proposal> proposal = proposalService.getallproposal();
        // List<Comment> list = commentService.getAllComment();
        request.setAttribute("proposal", proposal);
        Member member1 = memberService.findaname(member);
        if (member1.getUsergroup() == 2)
            return "/m_proposal_approval_recommend.html";
        else if (member1.getUsergroup() == 3)
            return "/m_proposal_approval_backup.html";
        else if (member1.getUsergroup() == 4)
            return "/m_proposal_approval_ensure.html";
        else
            return "/m_func_choose.html";
    }
    //主页
    /*
    @RequestMapping(value = "/注册界面.html",method = RequestMethod.GET)
    public String index(Model model){
        return "注册界面.html";
    }
    */

    @RequestMapping("/index")
    public String index(Model model, HttpServletRequest request) {
        System.out.println("nb了");
        getSession().invalidate();
        List<Standard> standards = standardService.getallStandard();
        System.out.println(standards);
        request.setAttribute("standard", standards);

        model.addAttribute("member", new Member());
        return "login_menu.html";
    }

    @RequestMapping("/登录后界面-信息维护.html")
    public String imfoMaintain() {
        return "登录后界面-信息维护.html";
    }

    @RequestMapping("/登录后界面-提案查询-写者.html")
    public String proposalWriter() {
        return "写者-提案查询.html";
    }

    /*
        @RequestMapping("/登录后界面-提案查询-管理.html")
        public String  proposalManage(){
            return "登录后界面-提案查询-管理.html";
        }
    */
    @RequestMapping("/登录后界面-提案编制.html")
    public String proposalMake() {
        return "写者-提案编制.html";
    }

    @RequestMapping("/登录后界面-提案详情.html")
    public String proposalDetail() {
        return "写者-提案详情.html";
    }

    @RequestMapping("login_menu")
    public String index2(Model model) {
        System.out.println("安排");
        model.addAttribute("member", new Member());
        return "login_menu.html";
    }


    @RequestMapping("m_func_choose.html")
    public String choice2() {
        return "/m_func_choose.html";
    }

    @RequestMapping("w_func_choose_formanage.html")
    public String choice1() {
        return "/w_func_choose_formanage.html";
    }


    @RequestMapping("/infor_mation")
    public String maintain(Model model) {
        Member member = (Member) getSession().getAttribute("member_name");
        Member member1 = memberService.findaname(member);
        model.addAttribute("member", new Member());
        model.addAttribute("member1", member1);
        return "/w_imfo_maintain.html";
    }

    @RequestMapping(value = "/infor_update", method = RequestMethod.GET)
    public String update(@ModelAttribute("member") Member member, Model model) {
        System.out.println("hei");
        Member member1 = (Member) getSession().getAttribute("member_name");

        member.setName(member1.getName());
        System.out.println(member);

        memberService.update(member);
        System.out.println("hei");
        return "w_func_choose.html";
    }

    @PostMapping(value = "/agreeornot", params = "checkbox")
    public String delete(@RequestParam("checkbox") String[] index, @RequestParam("ag") String agree) {
        System.out.println(agree);
        if (agree.equals("disagree")) {
            for (String it : index) {
                System.out.println(it);
                memberService.deletemember(it);
            }
        }
            else
            {
                for (String it : index) {
                    System.out.println(it);
                    memberService.updategroup(it);
                }

        }
        return "redirect:/getallmember";
    }
}



