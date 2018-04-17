package com.wallfacerrzd.blog.controller;

import com.wallfacerrzd.blog.domain.Article;
import com.wallfacerrzd.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author
 * @date
 */
@RestController
public class PageController {
    private ArticleService articleService;

    @Autowired
    public PageController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping("/essay")
    public ModelAndView essay() {
        return new ModelAndView("essay");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping("/article/{id}")
    public ModelAndView article(@PathVariable("id") String id) {
        String content = articleService.getArticleContent(Integer.parseInt(id));
        if ("".equals(content)) {
            return new ModelAndView("redirect:/index");
        } else {
            ModelAndView modelAndView = new ModelAndView("article");
            modelAndView.addObject("content", content);
            return modelAndView;
        }
    }

    @RequestMapping(value = "/uploadForm", method = RequestMethod.GET)
    public ModelAndView uploadForm() {
        return new ModelAndView("uploadForm");
    }
}
