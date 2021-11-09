package pl.coderslab.SpringCMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.SpringCMS.dao.ArticleRepository;

@Controller
public class HomePageController {

    private final ArticleRepository articleRepository;


    public HomePageController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

//    @GetMapping("/")
//    public String home(Model model) {
//        model.addAttribute("articles", articleRepository.findTop5ByOrderById());
//        return "articles";
//    }
//
//




}
