package com.process.newsfeed.service;

import com.process.newsfeed.entity.category.Category;
import com.process.newsfeed.repository.CategoryRepository;
import com.process.newsfeed.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

   private final CategoryRepository categoryRepository;
   private final NewsRepository newsRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, NewsRepository newsRepository) {
        this.categoryRepository = categoryRepository;
        this.newsRepository = newsRepository;
    }

    public List<Category> findAllCategories(){
        return categoryRepository.findAll();
    }
    public void saveCategory(Category category, long id){
        category.setPrimaryNews(newsRepository.findOne(id));
        categoryRepository.save(category);
    }

}
