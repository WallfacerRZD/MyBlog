package com.wallfacerrzd.blog.advisors;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author WallfacerRZD
 * @date 2018/5/28 16:19
 */
@Aspect
@Component
public class LimitCommenting {
    private final Map<String, Boolean> id2Count = new ConcurrentHashMap<>();
    private final ExecutorService removeKeyService = Executors.newFixedThreadPool(1);

    @Around("execution(public void com.wallfacerrzd.blog.controller.CommentController.insertComments(..))")
    public void limitCommenting(final ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = null;
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof HttpServletRequest) {
                request = (HttpServletRequest) arg;
                break;
            }
        }
        System.out.println("test");
        if (request != null) {
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
                joinPoint.proceed();
            } else {
                // comment too often, do nothing
            }
        } else {
            // miss request parameter
            // do nothing
        }

    }
}
