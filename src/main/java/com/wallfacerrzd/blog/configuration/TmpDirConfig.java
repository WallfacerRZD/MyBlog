package com.wallfacerrzd.blog.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * @author WallfacerRZD
 * @date 2018/10/1 11:10
 */
@Configuration
public class TmpDirConfig {
    @Value("${com.wallfacerrzd.blog.articlepath}")
    private String articlePath;

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(articlePath);
        return factory.createMultipartConfig();
    }
}
