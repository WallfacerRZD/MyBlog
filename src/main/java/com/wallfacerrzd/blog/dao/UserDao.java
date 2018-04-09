package com.wallfacerrzd.blog.dao;

import com.wallfacerrzd.blog.domain.User;
import com.wallfacerrzd.blog.mapping.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author
 * @date
 */
@Repository
public class UserDao {
    private final UserMapper userMapper;

    @Autowired
    public UserDao(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User selectUserById(int id) {
        return userMapper.selectUser(id);
    }

    public void insertUser(String userName, String password) {
        userMapper.insertUser(userName, password);
    }
}
