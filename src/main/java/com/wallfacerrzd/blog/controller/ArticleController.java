package com.wallfacerrzd.blog.controller;

import com.wallfacerrzd.blog.domain.Article;
import com.wallfacerrzd.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/article/{id}")
    public ModelAndView article() {
        return new ModelAndView("article");
    }

    @PostMapping("/article")
    public String articleContent(@RequestParam("articleId") String id) {
        String content = articleService.getArticleContent(Integer.parseInt(id));
        if ("".equals(content)) {
            return "# 哦噢! 文章走丢了\n" +
                    "别着急别着急, 东老师还没写这篇文章呢,";
        } else {
            return content;
        }
    }

}
