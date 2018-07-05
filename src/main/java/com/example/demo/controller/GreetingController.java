package com.example.demo.controller;

import com.example.demo.entity.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting.html";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute(value = "greeting") Greeting greeting) {

        return "result.html";
    }

}

