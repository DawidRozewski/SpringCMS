package pl.coderslab.SpringCMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.SpringCMS.repository.ArticleRepository;
import pl.coderslab.SpringCMS.repository.AuthorRepository;
import pl.coderslab.SpringCMS.repository.CategoryRepository;
import pl.coderslab.SpringCMS.entity.Article;
import pl.coderslab.SpringCMS.entity.Author;
import pl.coderslab.SpringCMS.entity.Category;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;

    public ArticleController(ArticleRepository articleRepository, CategoryRepository categoryRepository, AuthorRepository authorRepository) {
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
    }

    private List<String> list = Arrays.asList(
            "Dawid",
            "Milena",
            "dupa");


    @GetMapping("/all")
    public String showAll(Model model ) {
        model.addAttribute("articles", articleRepository.findAll());
        return "/article/all";
    }

    @GetMapping("/add")
    public String prepareToAdd(Model model) {
        model.addAttribute("article", new Article());
        return "/article/add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("article") @Valid Article article, BindingResult result) {
        if(result.hasErrors()) {
            return "/article/add";
        }
        articleRepository.save(article);
        return "redirect:/article/all";
    }

    @GetMapping("/edit")
    public String prepareToEdit(@RequestParam long id, Model model) {
        model.addAttribute("article", articleRepository.findById(id));
        return "/article/add";
    }

    @PostMapping("/edit")
    public String merge(@ModelAttribute("article") @Valid Article article, BindingResult result) {
        if(result.hasErrors()) {
            return "/article/add";
        }
        articleRepository.save(article);
        return "redirect:/article/all";
    }

    @GetMapping("/remove")
    public String prepareToRemove(@RequestParam long id, Model model) {
        model.addAttribute("article", articleRepository.getById(id));
        return "/article/remove";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam String confirmed, @RequestParam long id) {
        if ("yes".equals(confirmed)) {
            articleRepository.deleteById(id);
        }
        return "redirect:/article/all";
    }

    @ModelAttribute("now")
    public LocalDateTime now() {
        return LocalDateTime.now();
    }

    @ModelAttribute("authors")
    public List<Author> authorList() {
        return authorRepository.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> categoryList() {
        return categoryRepository.findAll();
    }

}
