package com.process.newsfeed.utils;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class RequestData {
    private Long id;
    private String name;
    private String content;
    private Date publication_date;
    private Long category_id;
}
