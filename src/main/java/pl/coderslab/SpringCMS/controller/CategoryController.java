package pl.coderslab.SpringCMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.SpringCMS.dao.CategoryDao;
import pl.coderslab.SpringCMS.entity.Category;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("/all")
    public String getAllCategories(Model model){
        model.addAttribute("categories", categoryDao.findAll());
        return "/category/showAll";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "/category/addForm";
    }

    @PostMapping("/add")
    public String saveCategory(@ModelAttribute("category") Category category) {
        categoryDao.persist(category);
        return "redirect:/category/all";
    }



}
