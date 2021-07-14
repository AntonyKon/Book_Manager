package ru.application.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.application.mvc.dao.GenreDao;

@Controller
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreDao genreDao;

    @GetMapping()
    public String showGenres(Model model) {
        model.addAttribute("genres", genreDao.findAll());

        return "genres/index";
    }
}
