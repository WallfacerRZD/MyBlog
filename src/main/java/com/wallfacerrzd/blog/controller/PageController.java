package com.wallfacerrzd.blog.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.Scanner;

/**
 * @author
 * @date
 */
@RestController
public class PageController {
    @RequestMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping("/md2html")
    public ModelAndView md2html() {
        return new ModelAndView("md2html");
    }

    @RequestMapping("/getmd")
    public String getMd() {
        Resource resource = new ClassPathResource("test.md");
        StringBuilder content = new StringBuilder();
        try(Scanner scanner = new Scanner(
                new InputStreamReader(resource.getInputStream(), "utf-8"))) {
            while (scanner.hasNext()) {
                content.append(scanner.nextLine()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
