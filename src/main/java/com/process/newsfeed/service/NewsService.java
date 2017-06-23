package com.process.newsfeed.service;

import com.process.newsfeed.entity.category.Category;
import com.process.newsfeed.entity.news.News;
import com.process.newsfeed.repository.CategoryRepository;
import com.process.newsfeed.repository.NewsRepository;
import com.process.newsfeed.utils.RequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
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
    public void update(News data){
        data.setDate_publication(new Date());
        newsRepository.save(data);
    }
    public void save(News data){
        data.setDate_publication(new Date());
        newsRepository.save(data);
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

    public News findById(long id){
        return newsRepository.findOne(id);
    }

}
