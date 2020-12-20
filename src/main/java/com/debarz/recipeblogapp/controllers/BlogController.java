package com.debarz.recipeblogapp.controllers;

import com.debarz.recipeblogapp.domain.Post;
import com.debarz.recipeblogapp.domain.security.User;
import com.debarz.recipeblogapp.services.PostService;
import com.debarz.recipeblogapp.services.UserService;
import com.debarz.recipeblogapp.util.PageHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Slf4j
@AllArgsConstructor
@Controller
public class BlogController {
    private final UserService userService;

    private final PostService postService;


    @RequestMapping(value = "/blog/{username}", method = RequestMethod.GET)
    public String blogForUsername(@PathVariable String username,
                                  @RequestParam(defaultValue = "0") int page,
                                  Model model) {

        Optional<User> optionalUser = userService.findByUsername(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Page<Post> posts = postService.findByUserOrderedByDatePageable(user, page);
            PageHandler pager = new PageHandler(posts);

            model.addAttribute("pager", pager);
            model.addAttribute("user", user);

            return "/posts";

        } else {
            return "/error";
        }
    }
}
