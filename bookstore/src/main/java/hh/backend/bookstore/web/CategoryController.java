package hh.backend.bookstore.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hh.backend.bookstore.domain.Category;
import hh.backend.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository repository) {
        this.categoryRepository = repository;
    }

    // categorylist
    @GetMapping("/categorylist")
    public String categorylist(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categorylist"; // categprylist.html
    }

    // add new category
    @GetMapping("/addcategory")
    public String addcategory(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory"; //addcategory.html
    }

    // save new category
    @PostMapping("/savecategory")
    public String save(Category category) {
        categoryRepository.save(category);
        return "redirect:categorylist";
    }
}
