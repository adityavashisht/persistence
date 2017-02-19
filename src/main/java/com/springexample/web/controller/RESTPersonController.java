package com.springexample.web.controller;


import com.springexample.persistence.dto.JsonResponse;

import com.springexample.persistence.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;



/**
 * Created by Ady on 2/18/17.
 */
@RestController
@RequestMapping("/table")
public class RESTPersonController {

    @Autowired
    private PersonService personService;


    //@ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/view/all")
    public ResponseEntity<JsonResponse> findAll() {
        JsonResponse jsonResponse = new JsonResponse(personService.getAll());
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);

    }
}
