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
    @Select("SELECT * FROM admin where id = #{id}")
    User selectUser(int id);

    @Insert("INSERT INTO admin (userName, password) VALUES (#{userName}, #{password})")
    void insertUser(@Param("userName")String userName, @Param("password")String password);
}
