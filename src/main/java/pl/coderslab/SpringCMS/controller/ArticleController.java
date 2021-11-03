package pl.coderslab.SpringCMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.SpringCMS.dao.ArticleDao;
import pl.coderslab.SpringCMS.dao.AuthorDao;
import pl.coderslab.SpringCMS.dao.CategoryDao;
import pl.coderslab.SpringCMS.entity.Article;
import pl.coderslab.SpringCMS.entity.Author;
import pl.coderslab.SpringCMS.entity.Category;

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
        return "article/all";
    }

    @GetMapping("/add")
    public String prepareToAdd(Model model) {
        model.addAttribute("article", new Article());
        return "article/add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("article") Article article) {
        articleDao.persist(article);
        return "redirect:/article/all";
    }

    @ModelAttribute("authors")
    public List<Author> authorList() {
        return this.authorDao.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return this.categoryDao.findAll();
    }

}
