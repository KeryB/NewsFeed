package com.process.newsfeed.controller;


import com.process.newsfeed.service.CategoryService;
import com.process.newsfeed.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UrlController {

    private final NewsService newsService;

    private final CategoryService categoryService;

    @Autowired
    public UrlController(NewsService newsService, CategoryService categoryService) {
        this.newsService = newsService;
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/")
    public String showTemplate(){
        return "/Menu";
    }

    @RequestMapping(value = "/findAllNews/edit")
    public String showEdit(@RequestParam("editNews") long id,Model model){
        model.addAttribute("edit",newsService.findById(id));
//        model.addAttribute("categories",categoryService.findCategoriesByIdNews(id));
        return "/edit";
    }
    @RequestMapping(value = "/cancel")
    public String cancel(){
        return "redirect:/";
    }
    @RequestMapping(value = "/toNews")
    public String toNews(){
        return "redirect:/findAllNews";
    }
    @RequestMapping(value = "/find")
    public String findNews(Model model){
        model.addAttribute("bool",false);
        return "findNews";
    }
    @RequestMapping(value = "/addNews")
    public String addNews(Model model){
        model.addAttribute("categories",categoryService.findAllCategories());
        return "add";
    }
    @RequestMapping(value = "/findContent")
    public String find(Model model){
        model.addAttribute("bool",false);
        return "find";
    }
    @RequestMapping(value = "/addCategory")
    public String addCategory(Model model){
        model.addAttribute("newsList",newsService.findAllNews());
        return "category";
    }
}
