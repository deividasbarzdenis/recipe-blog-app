package com.debarz.recipeblogapp.controllers;

import com.debarz.recipeblogapp.domain.Post;
import com.debarz.recipeblogapp.domain.security.User;
import com.debarz.recipeblogapp.services.PostService;
import com.debarz.recipeblogapp.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Controller
public class PostController {
    private final PostService postService;
    private final UserService userService;

    @GetMapping("/newPost")
    public String newPost(Principal principal,
                          Model model) {

        Optional<User> user = userService.findByUsername(principal.getName());

        if (user.isPresent()) {
            Post post = new Post();
            post.setUser(user.get());

            model.addAttribute("post", post);

            return "/postForm";

        } else {
            return "/error";
        }
    }

    @PostMapping("/newPost")
    public String createNewPost(@Valid Post post,
                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/postForm";
        } else {
            postService.save(post);
            return "redirect:/blog/" + post.getUser().getUsername();
        }
    }

    @GetMapping("/editPost/{id}")
    public String editPostWithId(@PathVariable Long id,
                                 Principal principal,
                                 Model model) {

        Optional<Post> optionalPost = postService.findForId(id);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();

            if (isPrincipalOwnerOfPost(principal, post)) {
                model.addAttribute("post", post);
                return "/postForm";
            } else {
                return "/403";
            }

        } else {
            return "/error";
        }
    }

    @GetMapping("/post/{id}")
    public String getPostWithId(@PathVariable Long id,
                                Principal principal,
                                Model model) {

        Optional<Post> optionalPost = postService.findForId(id);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();

            model.addAttribute("post", post);
            if (isPrincipalOwnerOfPost(principal, post)) {
                model.addAttribute("username", principal.getName());
            }

            return "/post";

        } else {
            return "/error";
        }
    }

    @DeleteMapping("/post/{id}")
    public String deletePostWithId(@PathVariable Long id,
                                   Principal principal) {

        Optional<Post> optionalPost = postService.findForId(id);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();

            if (isPrincipalOwnerOfPost(principal, post)) {
                postService.delete(post);
                return "redirect:/home";
            } else {
                return "/403";
            }

        } else {
            return "/error";
        }
    }

    private boolean isPrincipalOwnerOfPost(Principal principal, Post post) {
        return principal != null && principal.getName().equals(post.getUser().getUsername());
    }
}
