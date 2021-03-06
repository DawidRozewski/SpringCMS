package pl.coderslab.SpringCMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.SpringCMS.repository.CategoryRepository;
import pl.coderslab.SpringCMS.entity.Category;

import javax.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/all")
    public String getAllCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "category/showAll";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/addForm";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("category") @Valid Category category, BindingResult result) {
        if(result.hasErrors()) {
            return "/category/addForm";
        }
        categoryRepository.save(category);
        return "redirect:/category/all";
    }

    @GetMapping("/edit")
    public String prepareToEdit(@RequestParam long id, Model model) {
        model.addAttribute("category", categoryRepository.getById(id));
        return "category/addForm";
    }

    @PostMapping("/edit")
    public String merge(@ModelAttribute("category") @Valid Category category, BindingResult result) {
        if(result.hasErrors()) {
            return "/category/edit";
        }
        categoryRepository.save(category);
        return "redirect:/category/all";
    }

    @GetMapping("/remove")
    public String prepareToRemove(@RequestParam long id, Model model) {
        model.addAttribute("category", categoryRepository.getById(id));
        return "category/remove";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam String confirmed, @RequestParam long id) {
        if ("yes".equals(confirmed)) {
            categoryRepository.deleteById(id);
        }
        return "redirect:/category/all";
    }
}
