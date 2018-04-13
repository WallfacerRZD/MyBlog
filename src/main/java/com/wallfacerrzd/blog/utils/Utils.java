package com.wallfacerrzd.blog.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author
 * @date
 */
public final class Utils {
    private Utils() {

    }

    public static String markdown2Html(String mdPath) {
        Resource resource = new ClassPathResource(mdPath);
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
}
