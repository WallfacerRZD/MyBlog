package com.wallfacerrzd.blog.controller;

import com.wallfacerrzd.blog.service.ArticleStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author
 * @date
 */
@RestController
public class FileUploadController {
    private final ArticleStorageService articleStorageService;

    @Autowired
    public FileUploadController(ArticleStorageService articleStorageService) {
        this.articleStorageService = articleStorageService;
    }


    @PostMapping("/articles")
    public ModelAndView handleFileUpload(@RequestParam("file") MultipartFile file,
                                         @RequestParam("fileName") String fileName,
                                         @RequestParam("fileType") String fileType) {
        articleStorageService.store(file, fileName, fileType);
        return new ModelAndView("redirect:/index");
    }
}
