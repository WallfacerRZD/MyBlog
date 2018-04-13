package com.wallfacerrzd.blog.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author
 * @date
 */
@Component
public class Configuration {
    public String getArticlePath() {
        return articlePath;
    }

    public void setArticlePath(String articlePath) {
        this.articlePath = articlePath;
    }

    @Value("${com.wallfacerrzd.blog.articlepath}")
    private String articlePath;
}
