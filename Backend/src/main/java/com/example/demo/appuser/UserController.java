package com.example.demo.appuser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    
    @GetMapping("")
    public String ViewHomePage() {
        return "index";
    }
}
