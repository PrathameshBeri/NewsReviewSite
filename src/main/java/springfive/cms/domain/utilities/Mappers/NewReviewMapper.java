package springfive.cms.domain.utilities.Mappers;


import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import springfive.cms.domain.models.News;
import springfive.cms.vo.NewsReviewsDTO;

@Mapper(componentModel = "spring", uses = NewsReviewMapperInternal.class)
@Component
public interface NewReviewMapper {


    NewsReviewsDTO toNewsReviewsDTO(News news);

}
