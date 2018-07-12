package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RegistInformationController {
    @Autowired
    private StudentService studentService;


    @RequestMapping(value = "getregistinformation",method = RequestMethod.GET)
    public String getAllStudent(HttpServletRequest request){
        List<Student> list = studentService.getAllStudent();
        request.setAttribute("students",list);
        return "student";
    }

}
