package blogService.mapper;

import blogService.dto.BlogDto;
import blogService.entity.Blog;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class BlogMapper extends ConfigurableMapper {


    protected void configure(MapperFactory factory) {
        factory.classMap(Blog.class, BlogDto.class)
                .field("blogname", "blogName")
                .byDefault()
                .register();

    }

}
