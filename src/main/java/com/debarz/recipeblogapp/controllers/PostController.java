package com.debarz.recipeblogapp.controllers;

import com.debarz.recipeblogapp.domain.Post;
import com.debarz.recipeblogapp.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/post")
@Controller
public class PostController {

    private static final String POST_CREATE_OR_UPDATE_FORM = "post/newPost";

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //Del saugumo
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping({"", "/"})
    public String getPosts(){
        return "post";
    }

    @GetMapping("/new")//kurimo forma posto
    public String initCreationForm(Model model) {
        model.addAttribute("post", Post.builder().build());
        System.out.println(Post.builder().toString());
        return POST_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/")
    public String processCreationForm(@ModelAttribute Post post, BindingResult result) {
        if (result.hasErrors()) {
            return POST_CREATE_OR_UPDATE_FORM;
        } else {
            Post savePost =  postService.save(post);
            return "redirect:/"+savePost.getId()+"post/show";
        }
    }
    @GetMapping("/{id}/show")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("person", postService.findById(Long.valueOf(id)));
        return "post/show";
    }
}
