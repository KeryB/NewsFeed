package com.process.newsfeed.controller;

import com.process.newsfeed.entity.category.Category;
import com.process.newsfeed.entity.news.News;
import com.process.newsfeed.repository.NewsRepository;
import com.process.newsfeed.service.CategoryService;
import com.process.newsfeed.service.NewsService;
import com.process.newsfeed.utils.RequestData;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class NewsController {

    private final NewsService newsService;

    private final CategoryService categoryService;

    private Logger logger = Logger.getLogger(NewsController.class);

    @Autowired
    public NewsController(NewsService newsService, CategoryService categoryService) {
        this.newsService = newsService;
        this.categoryService = categoryService;
    }


    @RequestMapping(value = "/findAllNews")
    public String findAllNews(Model model){
        List<News> newsList = newsService.findAllNews();
        model.addAttribute("allNews",newsList);
        return "News";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String editNews(@ModelAttribute("updateNews") News news){
        newsService.update(news);
        return "redirect:/findAllNews";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addNews(@ModelAttribute("updateNews") News news,@RequestParam("selected") long id){
        newsService.save(news,id);
        return "redirect:/findAllNews";
    }

    @RequestMapping(value = "/findByName")
    public String findByName(@RequestParam("news") String news,Model model){
        model.addAttribute("news",newsService.findByName(news));
        model.addAttribute("bool",true);
        return "findNews";
    }

    @RequestMapping(value = "/findByCategories",method = RequestMethod.POST)
    public ResponseEntity findByCategories(@RequestBody RequestData data){
        return null;
    }

    @RequestMapping(value = "/findByContent",method = RequestMethod.POST)
    public String findByContent(@RequestParam("news") String news, Model model){
        model.addAttribute("findContent",newsService.findByContent(news));
        model.addAttribute("bool",true);
        return "find";
    }

    @RequestMapping(value="/deleteNews",method = RequestMethod.GET)
    public String deleteNews(@RequestParam("deleteNews") int id){
        newsService.deleteNews(id);
        return "redirect:/findAllNews";
    }
    @RequestMapping(value = "/saveCategory",method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute("form")Category category,@RequestParam("selected") long id){
        categoryService.saveCategory(category,id);
        return "redirect:/addNews";
    }
}
