package com.wallfacerrzd.blog.dao;

import com.wallfacerrzd.blog.domain.Article;
import com.wallfacerrzd.blog.mapping.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

/**
 * @author
 * @date
 */
@Repository
public class ArticleDao {
    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleDao(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    public List<Article> selectAllNodes() {
        return articleMapper.selectAllNodes();
    }

    public List<Article> selectAllEssays() {
        return articleMapper.selectAllEssays();
    }

    public Optional<Article> selectById(int id) {
        return Optional.ofNullable(articleMapper.selectById(id));
    }

    public void insert(String name, String path, String fileType, Timestamp time) {
        articleMapper.insert(name, path, fileType, time);
    }
}
