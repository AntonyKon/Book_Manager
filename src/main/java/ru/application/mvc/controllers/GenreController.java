package ru.application.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.application.mvc.models.Genre;
import ru.application.mvc.services.ManagementService;

@Controller
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private ManagementService service;

    @GetMapping()
    public String showGenres(Model model) {
        model.addAttribute("genres", service.findAllGenres());

        return "genres/index";
    }

    @GetMapping("/new")
    public String newGenre(@ModelAttribute("genre") Genre genre) {
        return "genres/new";
    }

    @PostMapping()
    public String addGenre(@ModelAttribute("genre") Genre genre) {
        service.saveGenre(genre);
        return "redirect:/genres";
    }
}
