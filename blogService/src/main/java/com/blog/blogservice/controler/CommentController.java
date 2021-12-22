package com.blog.blogservice.controler;

import com.blog.blogservice.dto.CommentDto;
import com.blog.blogservice.service.spi.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class CommentController {

    final CommentService commentService;

    @PostMapping("/posts/{articleId}/comments")
    public ResponseEntity<Object> createComment(@RequestBody final CommentDto commentDto,
                                                @PathVariable("articleId") final Long articleId) {
        final Long commentId = commentService.createComment(commentDto,articleId);
       if (commentId != null) {
           return ResponseEntity.ok(commentService.getCommentById(commentId));
       } else {
           return ResponseEntity.badRequest().body("Użytkownik nie ma uprawnień do publikacji na tym blogu");
       }
    }


}
