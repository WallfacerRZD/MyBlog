package com.wallfacerrzd.blog.service;

import com.wallfacerrzd.blog.dao.CommentDao;
import com.wallfacerrzd.blog.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * @author WallfacerRZD
 * @date 2018/5/23 20:12
 */
@Service
public class CommentService {
    private CommentDao commentDao;

    @Autowired
    public CommentService(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public List<Comment> getAllComments(int articleId) {
        return commentDao.getAllComment(articleId);
    }

    public void insertComment(int articleId, String content, Date date, String user) {
        commentDao.insertComment(articleId, content, date, user);
    }

    public void insertAnonymousComment(int articleId, String content, Date date) {
        commentDao.insertComment(articleId, content, date, "匿名");
    }
}
