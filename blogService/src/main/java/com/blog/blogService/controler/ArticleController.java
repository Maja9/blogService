package com.blog.blogService.controler;

import com.blog.blogService.dto.ArticleDto;
import com.blog.blogService.service.spi.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class ArticleController {

    ArticleService articleService;

    @PostMapping("/blogs/{id}/posts")
    public Long createArticle(@RequestBody final ArticleDto articleDto,
                              @PathVariable("id") final Long blogId)
        /* @RequestHeader("userId") final Long userId) */ {
        return articleService.createArticle(articleDto, blogId);
    }
}
