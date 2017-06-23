package com.process.newsfeed.repository;


import com.process.newsfeed.entity.category.Category;
import com.process.newsfeed.entity.news.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Locale;

public interface CategoryRepository extends JpaRepository<Category,Long>{
    Category findByTitle(String title);

}
