package pl.coderslab.SpringCMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String getAllCategories(Model model) {
        model.addAttribute("categories", categoryDao.findAll());
        return "/category/showAll";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "/category/addForm";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("category") Category category) {
        categoryDao.persist(category);
        return "redirect:/category/all";
    }

    @GetMapping("/edit")
    public String prepareToEdit(@RequestParam long id, Model model) {
        model.addAttribute("category", categoryDao.findById(id));
        return "/category/addForm";
    }

    @PostMapping("/edit")
    public String merge(@ModelAttribute("category") Category category) {
        categoryDao.merge(category);
        return "redirect:/category/all";
    }

    @GetMapping("/remove")
    public String prepareToRemove(@RequestParam long id, Model model) {
        model.addAttribute("category", categoryDao.findById(id));
        return "category/remove";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam String confirmed, @RequestParam long id) {
        if ("yes".equals(confirmed)) {
            categoryDao.remove(id);
        }
        return "redirect:/category/all";
    }


}
