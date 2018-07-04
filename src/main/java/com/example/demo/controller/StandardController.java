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

    @RequestMapping(value = "/stu/getAllStandards",method = RequestMethod.GET)
    public String getAllStandard(HttpServletRequest request){
        List<Standard> list = standardService.getAllStandard();
        request.setAttribute("standard",list);
        return "登录后界面-提案展示主界面.html";
    }
}
