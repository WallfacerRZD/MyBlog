package com.wallfacerrzd.blog.service;

import com.wallfacerrzd.blog.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${com.wallfacerrzd.blog.articlepath}")
    private String articlePath;

    @Autowired
    public ArticleStorageService(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public void store(MultipartFile multipartFile, String fileName, String fileType) {
        // 保存文件
        File file = new File(articlePath + fileName + ".md");
        System.out.println("---------------");
        System.out.println(file.getAbsolutePath());
        System.out.println("---------------");
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 将文件路径插入数据库
        articleDao.insert(fileName,
                file.getAbsolutePath(),
                fileType,
                new Timestamp(System.currentTimeMillis()));
    }


}
