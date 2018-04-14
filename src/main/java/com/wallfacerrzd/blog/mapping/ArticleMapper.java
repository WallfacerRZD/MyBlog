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
    @Select("SELECT * FROM article where type = 'node' ORDER BY id desc")
    List<Article> selectAllNodes();

    @Select("SELECT * FROM article where type = 'essay' ORDER BY id desc")
    List<Article> selectAllEssays();

    @Select("SELECT * FROM article WHERE id = #{id}")
    Article selectById(@Param("id")int id);

    @Insert("INSERT INTO article (name, path, time, type) " +
            "VALUES (#{name}, #{path}, #{time}, #{fileType})")
    void insert(@Param("name") String name, @Param("path") String path, @Param("fileType")String fileType, @Param("time") Timestamp time);
}
