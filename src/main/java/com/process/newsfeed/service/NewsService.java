package com.process.newsfeed.service;

import com.process.newsfeed.entity.category.Category;
import com.process.newsfeed.entity.news.News;
import com.process.newsfeed.repository.CategoryRepository;
import com.process.newsfeed.repository.NewsRepository;
import com.process.newsfeed.utils.RequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    private final NewsRepository newsRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository, CategoryRepository categoryRepository) {
        this.newsRepository = newsRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<News> findAllNews(){
        List<News> newsList = newsRepository.findAll();
        return newsList;
    }
    public void createAndUpdateNews(RequestData data){
        News news = new News();
        if(data.getId()!=null){
            news.setNews_id(data.getId());
        }
        news.setDate_publication(data.getPublication_date());
        news.setName(data.getName());
        news.setContent(data.getContent());
        newsRepository.save(news);
    }
    public void deleteNews(long id){
        newsRepository.delete(id);
    }
    public News findByCategories(String title){
        Category category= categoryRepository.findByTitle(title);
        return  categoryRepository.findByTitle(title).getPrimaryNews();
    }
    public News findByName(String name){
        return newsRepository.findByName(name);
    }
    public News findByContent(String content){
        return newsRepository.findByContent(content);
    }

}
