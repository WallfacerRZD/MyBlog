package com.wallfacerrzd.blog.mapping;

import com.wallfacerrzd.blog.domain.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author
 * @date
 */
@Mapper
@Component(value = "ArticleMapper")
public interface ArticleMapper {
    @Select("SELECT * FROM article")
    List<Article> selectAll();

    @Select("SELECT * FROM article WHERE id = #{id}")
    Article selectById(@Param("id")int id);

    @Insert("INSERT INTO article (name, path, time) " +
            "VALUES (#{name}, #{path}, #{time})")
    void insert(@Param("name") String name, @Param("path") String path, @Param("time") Timestamp time);
}
