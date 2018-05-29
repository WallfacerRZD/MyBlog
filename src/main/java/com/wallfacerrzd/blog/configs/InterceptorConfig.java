package com.wallfacerrzd.blog.configs;

import com.wallfacerrzd.blog.interceptors.CommentInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 * @author WallfacerRZD
 * @date 2018/5/29 17:40
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CommentInterceptor()).addPathPatterns("/comment");
    }
}
