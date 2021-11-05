package pl.coderslab.SpringCMS.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.SpringCMS.dao.ArticleDao;
import pl.coderslab.SpringCMS.dao.AuthorDao;
import pl.coderslab.SpringCMS.dao.CategoryDao;
import pl.coderslab.SpringCMS.entity.Article;
import pl.coderslab.SpringCMS.entity.Author;
import pl.coderslab.SpringCMS.entity.Category;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private final ArticleDao articleDao;
    private final CategoryDao categoryDao;
    private final AuthorDao authorDao;

    public ArticleController(ArticleDao articleDao, CategoryDao categoryDao, AuthorDao authorDao) {
        this.articleDao = articleDao;
        this.categoryDao = categoryDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/all")
    public String showAll(Model model) {
        model.addAttribute("articles", articleDao.findAll());
        return "/article/all";
    }

    @GetMapping("/add")
    public String prepareToAdd(Model model) {
        model.addAttribute("article", new Article());
        return "/article/add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("article") Article article,
                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime now) {

        article.setCreated(now);
        articleDao.persist(article);
        return "redirect:/article/all";
    }

    @GetMapping("/edit")
    public String prepareToEdit(@RequestParam long id, Model model) {
        model.addAttribute("article", articleDao.findById(id));
        return "/article/add";
    }

    @PostMapping("/edit")
    public String merge(@ModelAttribute("article") Article article) {
        articleDao.merge(article);
        return "redirect:/article/all";
    }

    @GetMapping("/remove")
    public String prepareToRemove(@RequestParam long id, Model model) {
        model.addAttribute("article", articleDao.findById(id));
        return "/article/remove";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam String confirmed, @RequestParam long id) {
        articleDao.remove(id);
        return "redirect:/article/all";
    }


    @ModelAttribute("now")
    public LocalDateTime now() {
        return LocalDateTime.now();
    }

    @ModelAttribute("authors")
    public List<Author> authorList() {
        return authorDao.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> categoryList() {
        return categoryDao.findAll();
    }

}
