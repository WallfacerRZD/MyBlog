package com.wallfacerrzd.blog.dao;

import com.wallfacerrzd.blog.domain.Comment;
import com.wallfacerrzd.blog.mapping.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * @author WallfacerRZD
 * @date 2018/5/23 20:05
 */
@Repository
public class CommentDao {
    private CommentMapper commentMapper;

    @Autowired
    public CommentDao(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public List<Comment> getAllComment(int articleId) {
        return commentMapper.selectAll(articleId);
    }

    public void insertComment(int articleId, String content, Date date, String user) {
        commentMapper.insertOne(articleId, content, date, user);
    }
}
