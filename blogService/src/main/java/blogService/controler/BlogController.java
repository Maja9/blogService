package blogService.controler;

import blogService.dto.BlogDto;
import blogService.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class BlogController {
    private final BlogService blogService;

    @PostMapping("/blogs")
    public Long createBlog(@RequestBody @Validated BlogDto blogDto){
        return blogService.createBlog(blogDto);

    }
}
