package com.blog.blogService.controler;

import com.blog.blogService.dto.ArticleDto;
import com.blog.blogService.service.spi.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class ArticleController {

    final ArticleService articleService;

    @PostMapping("/blogs/{blogId}/posts")
    public Long createArticle(@RequestBody final ArticleDto articleDto,
                              @PathVariable("blogId") final Long blogId) {
        return articleService.createArticle(articleDto, blogId);
    }
}
