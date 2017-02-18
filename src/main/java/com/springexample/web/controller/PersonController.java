package com.springexample.web.controller;

import com.springexample.persistence.domain.Person;
import com.springexample.persistence.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by Ady on 2/18/17.
 */
@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public String person(Model model, @RequestParam(value = "id", required = false) Long id) {
        // Create a form bean
        PersonForm personForm = new PersonForm();

        Person person = id == null ? new Person() : personService.load(id);
        personForm.setPerson(person);


        // Add the form object to the model
        model.addAttribute("personForm", personForm);

        return "person";// /WEB-INF/views/home.jsp"
    }

    @PostMapping
    public String save(@ModelAttribute("personForm") PersonForm personForm, RedirectAttributes redirectAttributes) {

        Person person = personForm.getPerson();
        person = personService.save(person);
        Long id = person.getId();

        // Rerdirect after post to avoid duplicate form submission
        redirectAttributes.addAttribute("id", id);

        return "redirect:person";
    }







}
