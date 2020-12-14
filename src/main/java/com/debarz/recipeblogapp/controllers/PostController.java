package com.debarz.recipeblogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/post")
@Controller
public class PostController {

    @RequestMapping({"", "/"})
    public String getPosts(){
        return "post";
    }
}
