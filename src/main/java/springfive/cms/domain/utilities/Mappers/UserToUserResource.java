package springfive.cms.domain.utilities.Mappers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springfive.cms.domain.models.News;
import springfive.cms.domain.models.Review;
import springfive.cms.domain.models.User;
import springfive.cms.domain.repository.NewsRepository;
import springfive.cms.domain.repository.ReviewRepository;
import springfive.cms.domain.repository.UserRepository;
import springfive.cms.vo.NewsDTO;
import springfive.cms.vo.ReviewRequest;
import springfive.cms.vo.UserArticleList;
import springfive.cms.vo.UserReviewsList;

import java.util.List;

@Component
public class UserToUserResource {

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    NewsMapper newsMapper;

    @Autowired
    ReviewMapper reviewMapper;


    List<NewsDTO> toUserArticleList(List<News> news){

        List<NewsDTO> newsDTOList = newsMapper.toNewsDTOList(news);

        return newsDTOList;

    }

    List<ReviewRequest> toUserReviewsList(List<Review> reviews){

        List<ReviewRequest> reviewRequests = reviewMapper.toReviewRequestList(reviews);

        return reviewRequests;


    }


}
