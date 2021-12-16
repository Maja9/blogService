package com.blog.blogservice.controler;

import com.blog.blogservice.dto.ArticleDto;
import com.blog.blogservice.service.spi.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class ArticleController {

    final ArticleService articleService;

    @PostMapping("/blogs/{blogId}/posts")
    public ResponseEntity<Object> createArticle(@RequestBody final ArticleDto articleDto,
                                                @PathVariable("blogId") final Long blogId) {
        final Long articleId = articleService.createArticle(articleDto, blogId);
        if (articleId != null) {
            return ResponseEntity.ok(articleService.getArticleById(articleId));
        } else {
            return ResponseEntity.badRequest().body("Użytkownik nie ma uprawnień do publikacji na tym blogu");
        }
    }

    @GetMapping("blogs/{blogId}/posts/{postId}")
    public ArticleDto articleDto(@PathVariable("postId") final Long postId,
                                 @PathVariable("blogId") final Long blogId) {
        return articleService.getArticleById(postId);
    }

    @PutMapping("blogs/{blogId}/posts/{postId}")
    public ResponseEntity<Object> editArticle(@RequestBody @Validated(ArticleDto.UpdateArticle.class) final ArticleDto articleDto,
                                              @PathVariable("postId") final Long articleId,
                                              @PathVariable("blogId") final Long blogId,
                                              @RequestHeader("userId") final Long userId) {
        if ((articleService.updateArticle(articleId, articleDto, userId, blogId)) != null) {
            return ResponseEntity.ok(articleService.getArticleById(articleId));
        } else {
            return ResponseEntity.badRequest().body("Użytkownik nie ma uprawnień do publikacji na tym blogu");
        }
    }
}