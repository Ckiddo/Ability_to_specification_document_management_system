package com.example.demo.controller;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Proposal;
import com.example.demo.service.CommentService;
import com.example.demo.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProposalController {

    @Autowired
    private ProposalService proposalService;
    private CommentService commentService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String getProposal(HttpServletRequest request){
        Proposal prop = proposalService.getProposal();
        List<Comment> list = commentService.getAllComment();
        request.setAttribute("",prop);
        request.setAttribute("",list);

        return "";
    }
}
