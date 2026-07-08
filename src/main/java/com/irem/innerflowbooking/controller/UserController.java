package com.irem.innerflowbooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    public static String currentUser = "Misafir";

    @GetMapping("/set-user")
    public String setUser(@RequestParam String name) {

        currentUser = name;

        return "redirect:/";
    }
}
