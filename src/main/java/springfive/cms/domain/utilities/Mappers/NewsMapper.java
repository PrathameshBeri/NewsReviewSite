package springfive.cms.domain.utilities.Mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import springfive.cms.domain.models.News;
import springfive.cms.vo.NewsDTO;

import java.util.List;

@Mapper(componentModel = "spring", uses = NewsMapperInternal.class)
@Component
public interface NewsMapper {

        @Mapping(source = "category.name", target = "category")
        NewsDTO toNewsDTO(News news);

        List<NewsDTO> toNewsDTOList(List<News> news);

        /**
         * @param newsDTO
         * @return
         */
        News toNews(NewsDTO newsDTO);

}
