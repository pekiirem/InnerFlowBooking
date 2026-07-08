package com.irem.innerflowbooking.controller;

import com.irem.innerflowbooking.controller.UserController;
import com.irem.innerflowbooking.entity.Session;
import com.irem.innerflowbooking.service.SessionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("sessions", sessionService.getAllSessions());
        model.addAttribute("currentUser",
                UserController.currentUser);
        return "index";
    }

    @GetMapping("/add")
    public String addSession() {

        Session session = new Session();

        session.setTitle("Morning Yoga");
        session.setInstructor("Emily");
        session.setLevel("Beginner");
        session.setCapacity(20);

        sessionService.saveSession(session);

        return "redirect:/";
    }

}