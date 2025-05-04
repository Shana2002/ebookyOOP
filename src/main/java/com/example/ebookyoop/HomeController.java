package com.example.ebookyoop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/shop")
    public String shop(){
        return "shop";
    }
}
