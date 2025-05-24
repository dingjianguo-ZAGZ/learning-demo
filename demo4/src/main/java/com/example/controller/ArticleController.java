package com.example.controller;

import com.example.domain.Article;
import com.example.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleMapper articleMapper;

    // 查询所有文章
    @GetMapping("/list")
    public String findAll(Model model) {
        List<Article> articleList= articleMapper.findAll();
        model.addAttribute("articleList", articleList);
        return "articleList"; // 返回视图模板 "article/list"
    }

    // 根据 id 查询单篇文章
    @GetMapping("/findById")
    public String findById(@RequestParam("id") int id, Model model) {
        Article article = articleMapper.findById(id);
        model.addAttribute("article", article);
        return "articleDetail"; // 返回视图模板 "article/detail"
    }

}
