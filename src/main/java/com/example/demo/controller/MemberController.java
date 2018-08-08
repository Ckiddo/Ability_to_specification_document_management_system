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
import java.util.ArrayList;
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
        if (memberService.findname(member) == 1 && memberService.getusergroup(member) == 1&&member.getIndustrybranch() == "写者分会")/////增加审核后改为1
        {
            HttpSession session = request.getSession();                     //
            session.setAttribute("member_name", member);            //
            return "w_func_choose.html";
        }

        if (memberService.findname(member) == 1 && memberService.getusergroup(member) ==1&&member.getIndustrybranch()!="写者分会" )//管理员
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
        String judge=member1.getIndustrybranch();
        if (member1.getUsergroup()==1&&judge.equals("写者分会"))
            return "/w_func_choose.html";
        else
            return "/m_func_choose.html";
    }

    @RequestMapping(value = "enterapproval", method = RequestMethod.GET)
    public String choice3(HttpServletRequest request) {
        Member member = (Member) getSession().getAttribute("member_name");
        System.out.println(member);

                Member member1 = memberService.findaname(member);
                String  Industrybranch=member1.getIndustrybranch();
        if (Industrybranch.equals("专委会")){
            List<Proposal> proposal = proposalService.getlevelpro("已提交");
            request.setAttribute("proposal", proposal);
            return "/m_proposal_approval_recommend.html";
        }
        else if (Industrybranch.equals("行业分会"))
        {
            List<Proposal> proposal = proposalService.getlevelpro("已推荐");
            request.setAttribute("proposal", proposal);
            return "/m_proposal_approval_backup.html";
        }
        else if (Industrybranch.equals("研究会"))
        {
            List<Proposal> proposal = proposalService.getlevelpro("已备案");
            request.setAttribute("proposal", proposal);
            return "/m_proposal_approval_ensure.html";
        }
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


    @RequestMapping(value = "/infor_mation1",method = RequestMethod.GET)
    public String mation1(@RequestParam("name") String name, Model model) {
        // request.setAttribute("comlist", list);
        Member member=new Member();
        member.setName(name);
        System.out.println(member);
        Member member1 = memberService.findaname(member);
        // List<Comment> list = commentService.getAllComment();
        model.addAttribute("member", new Member());
        System.out.println(member1);
        model.addAttribute("member1", member1);
        return "/w_member_recommend.html";
    }


    @RequestMapping(value = "/infor_update", method = RequestMethod.GET)
    public String update(@ModelAttribute("member") Member member, Model model) {
        System.out.println("hei");
        Member member1 = (Member) getSession().getAttribute("member_name");
        member.setRefed(member1.getName());
        member.setName(member1.getName());
        System.out.println(member);

        memberService.update(member);
        System.out.println("hei");
        return "redirect:/w_func_choose.html";
    }


    @RequestMapping(value = "/infor_update1", method = RequestMethod.GET)
    public String update1(@ModelAttribute("member") Member member,@RequestParam("name")String name, Model model) {
        System.out.println("hei");
        member.setName(name);
        System.out.println("要插入得系：：：==="+member);

        memberService.update(member);
        System.out.println("hei");
        return "redirect:/getreflist";
    }

    @PostMapping(value = "/agreeornot", params = "checkbox")
    public String agreemember1(@RequestParam("checkbox") String[] index, @RequestParam("ag") String agree) {
        System.out.println(agree);
        if (agree.equals("disagree")) {
            for (String it : index) {
                System.out.println("选中了：：：：："+it);
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


    @PostMapping(value = "/agreeornot1", params = "checkbox")
    public String agreemember2(@RequestParam("checkbox") String index, @RequestParam("ag") String agree) {
        System.out.println("1同意吗？"+agree);
        if (agree.equals("disagree")) {

                memberService.deletemember(index);

        }
        else
        {
                System.out.println("同意这个人：：："+index);
                memberService.updategroup(index);
        }
        return "redirect:/getallmember";
    }


    @RequestMapping(value = "/getreflist",method = RequestMethod.GET)
    public String getreflist(HttpServletRequest request){
        Member memberJ = (Member) getSession().getAttribute("member_name");
        List<Member> member1 = memberService.findref(memberJ.getName());
        System.out.println("mem1==="+member1);
        List<Member> member=new ArrayList();
        for(Member s:member1){
            if(s.getUsergroup()==0){
                member.add(s);
            }
        }
        System.out.println(member);
        request.setAttribute("member",member);
        return "w_ref_search.html";
    }





}



