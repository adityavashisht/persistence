package com.springexample.web.controller;

import com.springexample.persistence.domain.Person;
import com.springexample.persistence.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ady on 2/18/17.
 */
@Controller
@RequestMapping("/table")
public class RESTPersonController {

    @Autowired
    private PersonService personService;

    //@ResponseBody
    @RequestMapping(
            method = RequestMethod.POST,

            path = "/view/all/"
            )
    @ResponseBody
    public ResponseEntity<List<Person>> findAll() {

        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);

    }
}
