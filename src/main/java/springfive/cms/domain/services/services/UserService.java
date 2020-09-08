package springfive.cms.domain.services.services;


import org.springframework.stereotype.Service;
import springfive.cms.domain.models.User;
import springfive.cms.vo.UserArticleList;
import springfive.cms.vo.UserRequest;
import springfive.cms.vo.UserReviewsList;

import java.util.List;


public interface UserService {

    public UserRequest getOne(int id);

    public List<UserRequest> getAll();

    public UserRequest addUser(UserRequest usr);

    public void deleteUser(int id);

    public UserArticleList getArticles(String user);

    public UserReviewsList getReviews(String user);
}
