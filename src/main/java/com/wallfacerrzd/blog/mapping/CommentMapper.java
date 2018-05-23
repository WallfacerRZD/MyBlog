package com.wallfacerrzd.blog.mapping;

import com.wallfacerrzd.blog.domain.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

/**
 * @author WallfacerRZD
 * @date 2018/5/23 19:55
 */
@Mapper
@Component(value = "CommentMapper")
public interface CommentMapper {
    @Select("SELECT * FROM comment WHERE articleId = #{id} ORDER BY id DESC")
    List<Comment> selectAll(@Param("id") int id);

    @Insert("INSERT INTO comment (articleId, content, date, user)" +
            "VALUES (#{articleId}, #{content}, #{date}, #{user})")
    void insertOne(@Param("articleId") int articleId, @Param("content") String content, @Param("date") Date date, @Param("user") String user);
}
