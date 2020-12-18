package com.debarz.recipeblogapp.controllers;

import com.debarz.recipeblogapp.domain.Post;
import com.debarz.recipeblogapp.services.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Slf4j
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
        return POST_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/")
    public String processCreationForm(@ModelAttribute Post post, BindingResult result) {
        if (result.hasErrors()) {
            return POST_CREATE_OR_UPDATE_FORM;
        } else {
            log.debug("saving the Post to DB:" + post.getId());
            Post savePost =  postService.save(post);
            log.debug("Object saved");
            return "redirect:/post/"+savePost.getId()+"/show";
        }
    }
    @GetMapping("/{id}/show")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("post", postService.findById(Long.valueOf(id)));
        return "post/show";
    }
    @GetMapping("/{id}/delete")
    public String deleteById(@PathVariable String id){
        // TODO: prideti Exception
        log.debug("Deleting id: " + id);
        postService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }
    @GetMapping("/{id}/update")
    public String updatePost(@PathVariable String id, Model model){
        // TODO: prideti Exception
        model.addAttribute("person", postService.findById(Long.valueOf(id)));
        return POST_CREATE_OR_UPDATE_FORM;
    }
}
