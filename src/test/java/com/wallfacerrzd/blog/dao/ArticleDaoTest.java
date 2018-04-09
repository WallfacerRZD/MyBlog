package com.wallfacerrzd.blog.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

import static org.junit.Assert.*;

/**
 * @author
 * @date
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Rollback
@Transactional
public class ArticleDaoTest {
    @Autowired
    private ArticleDao articleDao;

    @Test
    public void selectAll() {
        articleDao.selectAll().forEach(System.out::println);
    }

    @Test
    public void insert() {
        for (int i = 0; i < 100; i++) {
            articleDao.insert(String.format("第%d篇文章", i), String.format("%d.md", i), new Timestamp(System.currentTimeMillis()));
        }
    }

    @Test
    public void insertAndSelectAll() {
        insert();
        selectAll();
    }
}