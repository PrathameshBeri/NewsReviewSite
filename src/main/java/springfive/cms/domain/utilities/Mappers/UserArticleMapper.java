package springfive.cms.domain.utilities.Mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;
import springfive.cms.domain.models.User;
import springfive.cms.vo.UserArticleList;
import springfive.cms.vo.UserReviewsList;

@Mapper( componentModel = "spring", uses = UserMapperInternal.class)
@Component
public interface UserArticleMapper {


    UserArticleList toUserArticles(User user);

}
