/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;


/**
 *
 * @author M. Calla
 */
@Controller
public class HelloWorldController {
    private String message = "Hello World";
    /*@RequestMapping("/")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "view.name";
    }*/

    @RequestMapping("/saludo")
    public String welcome(Map<String, Object> model) {
            model.put("message", this.message);
            return "helloWorld";
    }    
}
