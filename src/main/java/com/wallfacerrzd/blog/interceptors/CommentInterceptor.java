package com.wallfacerrzd.blog.interceptors;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 拦截频繁的评论
 *
 * @author WallfacerRZD
 * @date 2018/5/29 17:29
 */
public class CommentInterceptor extends HandlerInterceptorAdapter {
    private final Map<String, Boolean> id2Count = new ConcurrentHashMap<>();
    private final ExecutorService removeKeyService = Executors.newFixedThreadPool(1);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String ip = request.getLocalAddr();
        String url = request.getRequestURI();
        String key = "req_limit_".concat(ip).concat(url);
        if (id2Count.get(key) == null) {
            id2Count.put(key, true);
            removeKeyService.submit(() -> {
                try {
                    Thread.sleep(1000 * 5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                id2Count.remove(key);
            });
            return true;
        } else {
            try {
                response.sendError(403, "评论太快了");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
    }
}
