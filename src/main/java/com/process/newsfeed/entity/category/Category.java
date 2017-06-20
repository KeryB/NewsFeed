package com.process.newsfeed.entity.category;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.process.newsfeed.entity.news.News;
import com.process.newsfeed.utils.JpaUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = JpaUtils.CATEGORY_TABLE_NAME)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long category_id;

    private String title;

    @ManyToOne
    @JoinColumn(name = JpaUtils.NEWS_PRIMARY_KEY)
    @JsonBackReference
    private News primaryNews;

}
