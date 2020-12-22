package com.debarz.recipeblogapp.controllers;

import com.debarz.recipeblogapp.domain.Comment;
import com.debarz.recipeblogapp.domain.Post;
import com.debarz.recipeblogapp.domain.User;
import com.debarz.recipeblogapp.services.CommentService;
import com.debarz.recipeblogapp.services.PostService;
import com.debarz.recipeblogapp.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class CommentController {

    private final PostService postService;
    private final UserService userService;
    private final CommentService commentService;

    @PostMapping("/createComment")
    public String createNewPost(@Valid Comment comment,
                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "post/commentForm";

        } else {
            commentService.saveComment(comment);
            return "redirect:/post/" + comment.getPost().getId()+"/show";
        }
    }

    @RequestMapping(value = "/commentPost/{id}", method = RequestMethod.GET)
    public String commentPostWithId(@PathVariable Long id,
                                    Principal principal,
                                    Model model){
        Post post = postService.findById(id);
        if (post != null) {
            Optional<User> user = userService.findByUsername(principal.getName());
            if (user.isPresent()) {
                model.addAttribute("comment", Comment.builder().build());
                return "post/commentForm";

            } else {
                return "/error";
            }

        } else {
            return "/error";
        }
    }

}
