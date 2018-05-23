package com.wallfacerrzd.blog.controller;

import com.wallfacerrzd.blog.domain.Comment;
import com.wallfacerrzd.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

/**
 * @author WallfacerRZD
 * @date 2018/5/23 20:17
 */
@RestController
public class CommentController {
    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comment/{id}")
    public List<Comment> getComments(@PathVariable("id") int id) {
        return commentService.getAllComments(id);
    }

    @PostMapping("/comment")
    public void insertComments(@RequestParam("articleId") int id,
                                  @RequestParam("content") String content,
                                  @RequestParam("user") String user) {
        commentService.insertAnonymousComment(id, content, new Date(System.currentTimeMillis()));
    }
}
