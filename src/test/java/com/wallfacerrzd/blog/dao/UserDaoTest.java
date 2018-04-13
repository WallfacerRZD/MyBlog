package com.wallfacerrzd.blog.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author
 * @date
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {
    @Autowired
    UserDao userDao;

    @Test
    public void selectUser1() {
    }

    @Test
    public void insertUser() {
        userDao.insertUser("rzd", "123", false);
    }
}