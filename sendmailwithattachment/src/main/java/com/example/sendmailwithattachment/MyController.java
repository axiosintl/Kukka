package com.example.sendmailwithattachment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    @GetMapping("/text.html")
    public String examplePage() {
        // Your logic here
        return "text.html"; 
    }
}