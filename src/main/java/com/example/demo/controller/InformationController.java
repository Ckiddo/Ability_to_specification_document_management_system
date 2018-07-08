package com.example.demo.controller;

import com.example.demo.entity.Information;
import com.example.demo.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class InformationController {

    @Autowired
    private InformationService informationService;

    @RequestMapping(value = "/getinformation",method = RequestMethod.GET)
    public String getAllInformation(HttpServletRequest request){
        List<Information> list = informationService.getAllInformation();
        request.setAttribute("",list);
        return "";
    }
}
