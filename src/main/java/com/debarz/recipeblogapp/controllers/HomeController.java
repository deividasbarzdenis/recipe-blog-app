package com.debarz.recipeblogapp.controllers;

import com.debarz.recipeblogapp.domain.Post;
import com.debarz.recipeblogapp.services.PostService;
import com.debarz.recipeblogapp.util.PageHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@AllArgsConstructor
@Controller
public class HomeController {

    private final PostService postService;

    @GetMapping("/home")
    public String home(@RequestParam(defaultValue = "0") int page,
                       Model model) {

        Page<Post> posts = postService.findAllOrderedByDatePageable(page);
        PageHandler pager = new PageHandler(posts);

        model.addAttribute("pager", pager);

        return "/home";
    }
}
