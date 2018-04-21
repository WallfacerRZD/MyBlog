package com.wallfacerrzd.blog.utils;

import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author
 * @date
 */
public final class Utils {
    private Utils() {

    }

    public static String markdown2Html(String mdPath) {
        Resource resource = new PathResource(mdPath);
        StringBuilder content = new StringBuilder();
        try (Scanner scanner = new Scanner(resource.getInputStream(), "utf-8")) {
            while (scanner.hasNext()) {
                content.append(scanner.nextLine()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static String contentFromInputStream(InputStream inputStream) {
        StringBuilder content = new StringBuilder();
        try (Scanner scanner = new Scanner(inputStream, "utf-8")) {
            while (scanner.hasNext()) {
                content.append(scanner.nextLine()).append("\n");
            }
        }
        return content.toString();
    }

    public static int parseInteger(String id) {
        try {
            return Integer.parseInt(id);
        } catch (NumberFormatException e) {
            // 如果id不是数字, 返回数据库中不会出现的0作为错误返回值.
            return 0;
        }
    }
}
