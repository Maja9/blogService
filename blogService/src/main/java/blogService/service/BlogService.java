package blogService.service;

import blogService.dto.BlogDto;
import blogService.entity.Blog;
import blogService.mapper.BlogMapper;
import blogService.repository.BlogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;
    private final BlogMapper blogMapper;


    public Long createBlog(final BlogDto blogDto) {
        Blog blogToSave = blogMapper.map(blogDto, Blog.class);
        return blogRepository.save(blogToSave)
                .getBlogId();
    }
}
