package com.process.newsfeed.controller;

import com.process.newsfeed.entity.news.News;
import com.process.newsfeed.repository.NewsRepository;
import com.process.newsfeed.service.CategoryService;
import com.process.newsfeed.service.NewsService;
import com.process.newsfeed.utils.RequestData;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class NewsController {

    private final NewsService newsService;

    private final CategoryService categoryService;

    private Logger logger = Logger.getLogger(NewsController.class);

    @Autowired
    public NewsController(NewsService newsService, CategoryService categoryService) {
        this.newsService = newsService;
        this.categoryService = categoryService;
    }


    @RequestMapping(value = "/findAllNews", method = RequestMethod.POST)
    public ResponseEntity findAllNews(){
        return ResponseEntity.ok(newsService.findAllNews());
    }

    @RequestMapping(value = "/addAndUpdateNews", method = RequestMethod.POST)
    public void editNews(@RequestBody RequestData data){
        newsService.createAndUpdateNews(data);
    }

    @RequestMapping(value = "/findByName",method = RequestMethod.POST)
    public ResponseEntity findByName(@RequestBody RequestData data){
        return ResponseEntity.ok(newsService.findByName(data.getName()));
    }

    @RequestMapping(value = "/findByCategories",method = RequestMethod.POST)
    public ResponseEntity findByCategories(@RequestBody RequestData data){
        return ResponseEntity.ok(newsService.findByCategories(data.getTitle()));
    }

    @RequestMapping(value = "/findByContent",method = RequestMethod.POST)
    public ResponseEntity findByContent(@RequestBody RequestData data){
        return ResponseEntity.ok(newsService.findByContent(data.getContent()));
    }

    @RequestMapping(value="/deleteNews",method = RequestMethod.POST)
    public void deleteNews(@RequestBody RequestData data){
        newsService.deleteNews(data.getId());
    }
}
