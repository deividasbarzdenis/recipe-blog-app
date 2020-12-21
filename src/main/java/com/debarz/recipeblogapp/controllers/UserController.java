package com.debarz.recipeblogapp.controllers;

import com.debarz.recipeblogapp.domain.User;
import com.debarz.recipeblogapp.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequestMapping("/user")
@Controller
public class UserController {

    private static final String PERSON_CREATE_OR_UPDATE_FORM = "user/newUser";

    private final UserService userService;

    public UserController(UserService personService) {
        this.userService = personService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }


    @RequestMapping({"", "/"})
    public String getPerson(){
        return PERSON_CREATE_OR_UPDATE_FORM;
    }

    @GetMapping("/new")//kurimo forma posto
    public String newPerson(Model model) {
        model.addAttribute("user", User.builder().build());
        return PERSON_CREATE_OR_UPDATE_FORM;
    }
    @GetMapping("/{id}/update")
    public String updatePerson(@PathVariable String id, Model model){
        // TODO: prideti Exception
        model.addAttribute("user", userService.findById(Long.valueOf(id)));
        return PERSON_CREATE_OR_UPDATE_FORM;
    }
    @PostMapping("/")//+
    public String saveOrUpdate(@ModelAttribute User person){
        User savedUser = userService.save(person);
        return "redirect:/user/" + savedUser.getId() + "/show";
    }

    @GetMapping("/{id}/show")//+
    public String showById(@PathVariable String id, Model model){
        // TODO: prideti Exception
        model.addAttribute("user", userService.findById(Long.valueOf(id)));
        return "user/show";
    }

    @GetMapping("/{id}/delete")//+
    public String deleteById(@PathVariable String id){
        // TODO: prideti Exception
        log.debug("Deleting id: " + id);
        userService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }

}
