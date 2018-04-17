package com.wallfacerrzd.blog.controller;

import com.wallfacerrzd.blog.domain.Article;
import com.wallfacerrzd.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author
 * @date
 */
@RestController
public class ArticleController {
    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping("/notes")
    List<Article> getAllNotes() {
        return articleService.getAllNotes();
    }

    @RequestMapping("/essays")
    List<Article> getAllEssays() {
        return articleService.getAllEssays();
    }
}
