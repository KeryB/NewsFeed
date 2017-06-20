package com.process.newsfeed.entity.news;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.process.newsfeed.entity.category.Category;
import com.process.newsfeed.utils.JpaUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name= JpaUtils.NEWS_TABLE_NAME)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long news_id;

    private String name;

    private String content;

    private Date date_publication;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "primaryNews")
    @JsonManagedReference
    private List<Category> categories;
}
