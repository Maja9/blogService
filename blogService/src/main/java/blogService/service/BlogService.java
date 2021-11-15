package blogService.service;

import blogService.dto.BlogDto;
import blogService.entity.Blog;
import blogService.mapper.BlogMapper;
import blogService.repository.BlogRepository;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
    private final BlogRepository blogRepository;
    private final BlogMapper blogMapper;

    public BlogService (final BlogRepository blogRepository,
                        final BlogMapper blogMapper) {
        this.blogRepository = blogRepository;
        this.blogMapper = blogMapper;
    }

    public Long createBlog(BlogDto blogDto) {
        Blog blogToSave = blogMapper.map(blogDto, Blog.class);
       return blogRepository.save(blogToSave)
               .getBlogId();
    }
}
