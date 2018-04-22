package com.wallfacerrzd.blog.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
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
        List<Article> notes = articleService.getAllNotes();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("notes", notes);
        return modelAndView;
    }

    @RequestMapping("/essay")
    public ModelAndView essay() {
        List<Article> notes = articleService.getAllEssays();
        ModelAndView modelAndView = new ModelAndView("essay");
        modelAndView.addObject("essays", notes);
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("login");
    }


    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public ModelAndView uploadForm() {
        return new ModelAndView("uploadForm");
    }

}
