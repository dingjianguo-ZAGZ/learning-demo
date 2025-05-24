package com.example.mapper;

import com.example.domain.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ArticleMapper {
    public Article findById(int id);
    public List<Article> findAll();
}