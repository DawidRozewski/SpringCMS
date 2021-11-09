package pl.coderslab.SpringCMS.controller;

import org.springframework.stereotype.Controller;
import pl.coderslab.SpringCMS.repository.ArticleRepository;

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
