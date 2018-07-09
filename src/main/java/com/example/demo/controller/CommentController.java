package com.example.demo.controller;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Member;
import com.example.demo.entity.Proposal;
import com.example.demo.service.CommentService;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CommentController {

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
    private CommentService commentService;



    @RequestMapping(value = "cominsert",method = RequestMethod.GET) //
    public String getAllStudent(@ModelAttribute("comment")Comment comment, Model model, HttpServletRequest request){
      //  List<Comment> list = commentService.getAllComment();
        Member member=(Member)getSession().getAttribute("member_name") ;
        Proposal proposal=(Proposal)getSession().getAttribute("proposal_id");
        Date date =new Date();
        System.out.println("pPPPPPPPPPPPPPPPPPP IIIIIIDDDDDDDDDDD:"+proposal.getP_id());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
       comment.setCom_time(df.format(new Date()));// new Date()为获取当前系统时间
        comment.setMember_name(member.getName());
       comment.setP_id(proposal.getP_id());
       // request.setAttribute("",list);
        List<Comment> comment1 = commentService.getcomment(proposal.getP_id());
        System.out.println(comment1);
        // List<Comment> list = commentService.getAllComment();
        request.setAttribute("comment1", comment1);
        commentService.insert(comment);

        model.addAttribute("proposal", proposal);
        return "w_proposal_detail.html";
    }

}
