package com.example.demo.controller;

import com.example.demo.entity.Standard;
import com.example.demo.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StandardController {

    @Autowired
    private StandardService standardService;


    @RequestMapping(value = "getAllStandards",method = RequestMethod.GET)
    public String getAllStandard(HttpServletRequest request){
        List<Standard> list = standardService.getallStandard();
        request.setAttribute("standard",list);
        return "afterLogin_showStandard.html";
    }

    @RequestMapping(value = "getstandard", method = RequestMethod.GET)
    public String getProposal(HttpServletRequest request) {
        // request.setAttribute("comlist", list);
        return "w_proposal_search.html";
    }
}
