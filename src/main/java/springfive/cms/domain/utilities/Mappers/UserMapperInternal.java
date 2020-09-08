package springfive.cms.domain.utilities.Mappers;


import org.springframework.stereotype.Component;
import springfive.cms.domain.models.News;
import springfive.cms.domain.models.Review;
import springfive.cms.vo.NewsDTO;
import springfive.cms.vo.ReviewRequest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
public class UserMapperInternal {


    List<NewsDTO> toNewsDTO(Set<News> articles){

        List<NewsDTO>  listNewsDTO = new ArrayList<>();
        for(News news: articles){

            NewsDTO newDTO = new NewsDTO();

            newDTO.setTitle(news.getTitle());
            newDTO.setContent(news.getContent());
            newDTO.setCategory(news.getCategory().getName());
            newDTO.setAuthors(null);
            newDTO.setId(news.getId());

            listNewsDTO.add(newDTO);
        }

        return listNewsDTO;

    }

    List<ReviewRequest> toReviewRequest(Set<Review> reviews){

        List<ReviewRequest> reviewRequests = new ArrayList<>();
        for(Review review: reviews){

            ReviewRequest reviewReq = new ReviewRequest();
            reviewReq.setStatus(review.getStatus());
            reviewReq.setUser(null);
            reviewReq.setNews(review.getNews().getTitle());
            reviewRequests.add(reviewReq);
        }

        return reviewRequests;


    }
}
