package pl.coderslab.SpringCMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.SpringCMS.repository.AuthorRepository;
import pl.coderslab.SpringCMS.entity.Author;

import javax.validation.Valid;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/all")
    public String showAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "/author/all";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("author", new Author());
        return "author/add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("author") @Valid Author author, BindingResult result) {
       if(result.hasErrors()) {
           return "/author/add";
       }
        authorRepository.save(author);
        return "redirect:/author/all";
    }

    @GetMapping("/edit")
    public String prepareToEdit(@RequestParam long id, Model model) {
        model.addAttribute("author", authorRepository.getById(id));
        return "author/add";
    }

    @PostMapping("/edit")
    public String merge(@ModelAttribute("author") @Valid Author author, BindingResult result) {
        if(result.hasErrors()) {
            return "/author/add";
        }
        authorRepository.save(author);
        return "redirect:/author/all";
    }

    @GetMapping("/remove")
    public String prepareToRemove(@RequestParam long id, Model model) {
        model.addAttribute("author", authorRepository.getById(id));
        return "author/remove";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam String confirmed, @RequestParam long id) {
        if ("yes".equals(confirmed)) {
            authorRepository.deleteById(id);
        }
        return "redirect:/author/all";
    }


}
