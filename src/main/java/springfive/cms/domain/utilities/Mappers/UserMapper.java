package springfive.cms.domain.utilities.Mappers;


import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import springfive.cms.domain.models.User;
import springfive.cms.vo.UserArticleList;
import springfive.cms.vo.UserRequest;
import springfive.cms.vo.UserReviewsList;

import java.util.List;

@Mapper(componentModel = "spring", uses = UserToUserResource.class)
@Component
public interface UserMapper {



    UserRequest toUserRequest(User user);

    UserArticleList toUserArticleList(User user);

    UserReviewsList toUserReviewsList(User user);

    List<UserRequest> toListUserRequests(List<User> users);

    User toUser(UserRequest userR);


}
