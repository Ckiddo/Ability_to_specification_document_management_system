package com.example.demo.controller;

<<<<<<< HEAD
import com.example.demo.entity.Standard;
import com.example.demo.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
=======
import com.example.demo.entity.Member;
import com.example.demo.entity.Proposal;
import com.example.demo.entity.Standard;
import com.example.demo.service.ProposalService;
import com.example.demo.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
>>>>>>> wpf2

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StandardController {

    @Autowired
    private StandardService standardService;

<<<<<<< HEAD

    @RequestMapping(value = "/stu/getAllStandards",method = RequestMethod.GET)
    public String getAllStandard(HttpServletRequest request){
        List<Standard> list = standardService.getAllStandard();
        request.setAttribute("standard",list);
        return "afterLogin_showStandard.html";

    }
=======
    @RequestMapping(value = "getallstandard",method = RequestMethod.GET)
    public String getAllStandard(HttpServletRequest request){
        List<Standard> standard = standardService.getallStandard();
        request.setAttribute("standard",standard);
        return "w_norm_search.html";
    }

    @RequestMapping(value = "standarddetail", method = RequestMethod.GET)
    public String getOneStandard(@RequestParam("s_id") int s_id,Model model) {
        // request.setAttribute("comlist", list);
        Standard standard = standardService.getonestandard(s_id);
        // List<Comment> list = commentService.getAllComment();
        System.out.println(standard);
        model.addAttribute("standard", standard);
        return "w_norm_detail.html";
    }

    @RequestMapping(value = "getstandard", method = RequestMethod.GET)
    public String getStandard(HttpServletRequest request) {
        // request.setAttribute("comlist", list);
        return "w_proposal_search.html";
    }


    @RequestMapping(value = "stddetail", method = RequestMethod.GET)
    public String getProposal(@RequestParam("s_id") int s_id, Model model,HttpServletRequest request) {
        // request.setAttribute("comlist", list);
        Standard standard = standardService.getonestandard(s_id);
        // List<Comment> list = commentService.getAllComment();
        System.out.println(standard);
        List<Standard> standards = standardService.getallStandard();
        System.out.println(standards);
        model.addAttribute("standard", standards);
        System.out.println(standard.getStandard_content());
        model.addAttribute("member",new Member());
        request.setAttribute("std", standard.getStandard_content());
        return "login_menu.html";
    }



>>>>>>> wpf2
}
