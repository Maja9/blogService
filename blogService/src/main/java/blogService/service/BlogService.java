package blogService.service;

import blogService.dto.BlogDto;
import blogService.entity.Blog;
import blogService.mapper.BlogMapper;
import blogService.repository.BlogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public BlogDto getBlogById(final Long blogId) {
        Optional<Blog> blogOptional = blogRepository.findById(blogId);
        return blogOptional.map(blog -> blogMapper.map(blog, BlogDto.class))
                .orElse(null);
    }

    public BlogDto updateBlog(final Long blogId, final BlogDto blogDto, final Long userId) {

        final BlogDto blogFromDb = getBlogById(blogId);
        if (blogId.equals(blogFromDb.getBlogId()) && userId.equals(blogFromDb.getAuthor().getId())) {
            createBlog(blogDto);
            return getBlogById(blogId);
        }
        return null;
    }

}
