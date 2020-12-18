package com.debarz.recipeblogapp.controllers;

import com.debarz.recipeblogapp.domain.Person;
import com.debarz.recipeblogapp.services.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequestMapping("/person")
@Controller
public class PersonController {

    private static final String PERSON_CREATE_OR_UPDATE_FORM = "user/newUser";

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // TODO: Butina prideti
  /*  //Del saugumo
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }*/


    @RequestMapping({"", "/"})
    public String getPerson(){
        return PERSON_CREATE_OR_UPDATE_FORM;
    }

    @GetMapping("/new")//kurimo forma posto
    public String newPerson(Model model) {
        model.addAttribute("person", Person.builder().build());
        return PERSON_CREATE_OR_UPDATE_FORM;
    }
    @GetMapping("/{id}/update")
    public String updatePerson(@PathVariable String id, Model model){
        // TODO: prideti Exception
        model.addAttribute("person", personService.findById(Long.valueOf(id)));
        return PERSON_CREATE_OR_UPDATE_FORM;
    }
    @PostMapping("/")//+
    public String saveOrUpdate(@ModelAttribute Person person){
        Person savedPerson = personService.save(person);
        return "redirect:/person/" + savedPerson.getId() + "/show";
    }

    @GetMapping("/{id}/show")//+
    public String showById(@PathVariable String id, Model model){
        // TODO: prideti Exception
        model.addAttribute("person", personService.findById(Long.valueOf(id)));
        return "user/show";
    }

    @GetMapping("/{id}/delete")//+
    public String deleteById(@PathVariable String id){
        // TODO: prideti Exception
        log.debug("Deleting id: " + id);
        personService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }

}
