package com.debarz.recipeblogapp.controllers;

import com.debarz.recipeblogapp.services.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@AllArgsConstructor
@Controller
public class BlogController {

    final private PostService postService;

    @RequestMapping({"", "blog", "blog.html"})
    public String getAllPosts(@PageableDefault(size = 5) Pageable pageable, Model model){
        log.debug("geting to blog controller GetAllPosts");
        model.addAttribute("posts", postService.getAllPost(pageable));
        return "blog";
    }
}
