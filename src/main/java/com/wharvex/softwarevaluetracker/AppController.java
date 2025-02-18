package com.wharvex.softwarevaluetracker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.inject.Inject;

@Controller
public class AppController {

    @Inject
    AppRepository appRepository;

    @GetMapping("/app")
    public String appForm(Model model) {
        model.addAttribute("app", new App());
        return "app";
    }

    // The App is a @ModelAttribute, so it's bound to the incoming form content.
    @PostMapping("/app")
    public String appSubmit(@ModelAttribute App app, Model model) {
        model.addAttribute("app", app);
        appRepository.save(app);
        return "result";
    }
}
