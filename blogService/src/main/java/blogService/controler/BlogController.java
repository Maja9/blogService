package blogService.controler;

import blogService.dto.BlogDto;
import blogService.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class BlogController {
    private final BlogService blogService;

    @PostMapping("/blogs")
    public Long createBlog(@RequestBody @Validated final BlogDto blogDto) {
        return blogService.createBlog(blogDto);

    }

    @GetMapping("/blogs/{id}")
    public BlogDto getBlogById(@PathVariable("id") final Long blogId) {
        return blogService.getBlogById(blogId);
    }

    @PutMapping("/blogs/{id}")
    public ResponseEntity<Object> editBlog(@RequestBody @Validated(BlogDto.UpdateBlog.class) final BlogDto blogDto,
                                           @PathVariable("id") final Long blogId,
                                           @RequestHeader("userId") final Long userId) {

        if ((blogService.updateBlog(blogId, blogDto, userId)) != null) {
            return ResponseEntity.ok(blogService.getBlogById(blogId));
        } else {
            return ResponseEntity.badRequest().body("Uzytkownik nie ma uprawnien do edycji bloga");
        }
    }

}
