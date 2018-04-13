package com.wallfacerrzd.blog.service;

import com.wallfacerrzd.blog.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * @author
 * @date
 */
@Service
public class ArticleStorageService {
    private final ArticleDao articleDao;

    @Autowired
    public ArticleStorageService(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public void store(MultipartFile file, String fileName) {
        // 保存文件
        String articleDirectory = "F:/_projects/blog/src/main/resources/articles/";
        try {
            file.transferTo(new File(articleDirectory + fileName + ".md"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 将文件路径插入数据库
        articleDao.insert(fileName,
                String.format("articles/%s.md", fileName),
                new Timestamp(System.currentTimeMillis()));
    }


}
