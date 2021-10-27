package pl.coderslab.SpringCMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.SpringCMS.dao.AuthorDao;
import pl.coderslab.SpringCMS.entity.Author;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/all")
    public String showAuthors(Model model) {
        model.addAttribute("authors", authorDao.findAll());
        return "/author/all";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("author", new Author());
        return "/author/add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("author") Author author) {
        authorDao.persist(author);
        return "redirect:/author/all";
    }

}
