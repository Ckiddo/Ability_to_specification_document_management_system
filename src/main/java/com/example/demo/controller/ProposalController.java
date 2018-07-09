package com.example.demo.controller;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.example.demo.entity.Comment;
import com.example.demo.entity.Member;
import com.example.demo.entity.Proposal;
import com.example.demo.service.CommentService;
import com.example.demo.service.MemberService;
import com.example.demo.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class  ProposalController {

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
    private ProposalService proposalService;
    private CommentService commentService;

    // Member member= MemberService.

    @RequestMapping(value = "getallproposal", method = RequestMethod.GET)
    public String getallProposal(HttpServletRequest request) {
        List<Proposal> proposal = proposalService.getallproposal();
       // List<Comment> list = commentService.getAllComment();
        request.setAttribute("proposal", proposal);
       // request.setAttribute("comlist", list);

        return "w_proposal_search.html";
    }

    @RequestMapping(value = "getproposal", method = RequestMethod.GET)
    public String getProposal(HttpServletRequest request) {
        // request.setAttribute("comlist", list);
        return "w_proposal_search.html";
    }

    @RequestMapping(value = "prodetail", method = RequestMethod.GET)
    public String getProposal(@RequestParam("p_id") int p_id,Model model,HttpServletRequest request) {
        // request.setAttribute("comlist", list);
        Proposal proposal = proposalService.getoneproposal(p_id);
        // List<Comment> list = commentService.getAllComment();
        System.out.println(proposal);
//     List<Comment> comment1 = commentService.getcomment(p_id);
        // List<Comment> list = commentService.getAllComment();
        HttpSession session = request.getSession();                     //
        session.setAttribute("proposal_id",proposal);


        model.addAttribute("comment", new Comment());
        model.addAttribute("proposal", proposal);
        return "w_proposal_detail.html";
    }

    @RequestMapping(value = "/proinsert",method = RequestMethod.GET)
    public String insert(@ModelAttribute("proposal") Proposal proposal, Model model,HttpServletRequest request){
        System.out.println(proposal.getName());
        System.out.println(proposal.getContent());
        Member member=(Member)getSession().getAttribute("member_name") ;
        System.out.println("同步的名字："+member.getName());
        proposal.setAuthor(member.getName());
        proposal.setClose_time("2020-12-31");
        proposal.setStatus("已提交");
        proposal.setAgree_num(0);
        proposal.setDisagree_num(0);
        Date date =new Date();
        /*String year=String.format("%tY",date);
        String month=String.format("%tb",date);
        String day=String.format("%te",date);
        proposal.setSub_time(year+"-"+month+"-"+day);*/
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        proposal.setSub_time(df.format(new Date()));// new Date()为获取当前系统时间

        proposalService.insert(proposal);
        Member member1=(Member)getSession().getAttribute("member_name") ;
        List<Proposal> proposal1 = proposalService.getproposal(member1.getName());
        // List<Comment> list = commentService.getAllComment();
        request.setAttribute("proposal1", proposal1);
            return "/w_proposal_make.html";
    }


    @RequestMapping(value = "/enterproposal", method = RequestMethod.GET)
    public String indexMember(Model model,HttpServletRequest request) {
        Member member1=(Member)getSession().getAttribute("member_name") ;
        List<Proposal> proposal1 = proposalService.getproposal(member1.getName());
        model.addAttribute("proposal", new Proposal());
        request.setAttribute("proposal1", proposal1);
        System.out.println("");
        return "/w_proposal_make.html";
    }

    @PostMapping(value="/deletemy",params = "checkbox")
    public String deletemy(@RequestParam("checkbox") int[] index){
        for(int it:index)
        {System.out.println("获取了撤销位置："+it);
            proposalService.deleteproposal(it);}
        // Proposal proposal=null;
        return "redirect:/enterproposal";
    }

    @PostMapping(value="/delete")
    public String deleteEx(){return "redirect:/getallproposal";}

    @PostMapping(value="/delete",params = "checkbox")
    public String delete(@RequestParam("checkbox") int[] index){
        for(int it:index)
        {System.out.println(it);
            proposalService.deleteproposal(it);}
       // Proposal proposal=null;
        return "redirect:/getallproposal";
    }

}


