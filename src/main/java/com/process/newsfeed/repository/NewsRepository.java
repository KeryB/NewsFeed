package com.process.newsfeed.repository;

import com.process.newsfeed.entity.news.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News,Long>{
    News findByName(String name);
    News findByContent(String content);
}
