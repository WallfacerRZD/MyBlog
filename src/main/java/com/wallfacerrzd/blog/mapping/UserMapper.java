package com.wallfacerrzd.blog.mapping;

import com.wallfacerrzd.blog.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author
 * @date
 */
@Mapper
@Component(value = "UserMapper")
public interface UserMapper {
    @Select("SELECT * FROM user where userName = #{userName} and password = #{password}")
    User selectUser(@Param("userName")String userName, @Param("password")String password);

    @Insert("INSERT INTO user (userName, password, isAdmin) VALUES (#{userName}, #{password}, #{isAdmin})")
    void insertUser(@Param("userName") String userName, @Param("password") String password, @Param("isAdmin") boolean isAdmin);


}
