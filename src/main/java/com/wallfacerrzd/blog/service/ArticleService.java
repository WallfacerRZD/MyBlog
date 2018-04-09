package com.wallfacerrzd.blog.service;

import com.wallfacerrzd.blog.dao.ArticleDao;
import com.wallfacerrzd.blog.domain.Article;
import com.wallfacerrzd.blog.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author
 * @date
 */
@Service
public class ArticleService {
    private final ArticleDao articleDao;

    @Autowired
    public ArticleService(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public List<Article> getAllArticles() {
        return articleDao.selectAll();
    }

    public String getArticleContent(int id) {
        Optional<Article> result = articleDao.selectById(id);
        Article article = result.orElse(null);
        if (article != null) {
            return Utils.markdown2Html(article.getPath());
        } else {
            return "";
        }
    }

}
