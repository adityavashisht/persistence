package com.springexample.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Ady on 2/18/17.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String home() {
        return "home";// /WEB-INF/views/home.jsp"
    }
}
