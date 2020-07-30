package com.bida.springHomeWork.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String root(@RequestHeader Map<String, String> headers) {
        System.out.println(headers.keySet());
        System.out.println(headers.get("cookie"));
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
}
