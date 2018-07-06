package com.example.demo.controller;

import com.example.demo.entity.Greeting;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @description 
* @author Tim Lin
* @create 2018-07-01 
**/

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/stu/getAllStudent",method = RequestMethod.GET)
    public String getAllStudent(HttpServletRequest request){
        List<Student> list = studentService.getAllStudent();
        request.setAttribute("students",list);
        // aaaaaa
        return "student";
    }
    @RequestMapping("/index")
    public String  index(){
        return "主界面.html";
    }

    @RequestMapping("/注册界面.html")
    public String  register(){
        return "注册界面.html";
    }

    @RequestMapping("/登录后界面-信息维护.html")
    public String  imfoMaintain(){
        return "登录后界面-信息维护.html";
    }

    @RequestMapping("/登录后界面-提案查询-写者.html")
    public String  proposalWriter(){
        return "登录后界面-提案查询-写者.html";
    }

    @RequestMapping("/登录后界面-提案查询-管理.html")
    public String  proposalManage(){
        return "登录后界面-提案查询-管理.html";
    }

    @RequestMapping("/登录后界面-提案编制.html")
    public String  proposalMake(){
        return "登录后界面-提案编制.html";
    }

    @RequestMapping("/登录后界面-提案详情.html")
    public String  proposalDetail(){
        return "登录后界面-提案详情.html";
    }

    @RequestMapping("/主界面.html")
    public String  index2(){
        return "主界面.html";
    }

}

