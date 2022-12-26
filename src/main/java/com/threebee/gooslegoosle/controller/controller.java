package com.threebee.gooslegoosle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller {


    @GetMapping({ "", "/", "index" })
    public String index() {
         return "index";
    }
}