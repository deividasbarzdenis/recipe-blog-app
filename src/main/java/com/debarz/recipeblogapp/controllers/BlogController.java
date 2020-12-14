package com.debarz.recipeblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {

    @RequestMapping({"", "blog", "blog.html"})
    public String getBlog(){

        return "blog";
    }
}
