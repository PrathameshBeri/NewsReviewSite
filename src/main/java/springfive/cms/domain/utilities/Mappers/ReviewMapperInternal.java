package springfive.cms.domain.utilities.Mappers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springfive.cms.domain.models.News;
import springfive.cms.domain.models.Review;
import springfive.cms.domain.models.User;
import springfive.cms.domain.repository.NewsRepository;
import springfive.cms.domain.repository.UserRepository;
import springfive.cms.vo.ReviewRequest;

@Component
public class ReviewMapperInternal {

    @Autowired
    NewsRepository newsRepository;

    @Autowired
    UserRepository userRepository;



    User getUser(String reviewer){

        User user = userRepository.findByName(reviewer);
        return user;
    }

    News getNews(String articleTitle){

        News news  = newsRepository.findByTitle(articleTitle);
        return news;
    }

}
