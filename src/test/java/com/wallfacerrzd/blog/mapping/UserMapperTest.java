package com.wallfacerrzd.blog.mapping;

import com.wallfacerrzd.blog.dao.UserDao;
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
public class UserMapperTest {
    @Autowired
    private UserDao userDao;



    @Test
    public void insertUser() {
        for(int i = 0; i < 5; i++) {
            userDao.insertUser("w", "df");
        }
    }

    @Test
    public void selectUser() {
        for(int i = 0; i < 5; i++) {
            System.out.println(userDao.selectUserById(i));
        }
    }

    @Test
    public void insertAndSelect() {
        insertUser();
        selectUser();
    }

}