package springfive.cms.domain.utilities.Mappers;


import org.springframework.stereotype.Component;
import springfive.cms.domain.models.Review;
import springfive.cms.domain.models.User;
import springfive.cms.vo.ReviewRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class NewsReviewMapperInternal {



    String authorsToString(Set<User> authors){

        StringBuffer author = new StringBuffer();

        authors.stream().forEach(user -> author.append(", " + user.getName()));

        return new String(author);

    }

    List<ReviewRequest> reviews(Set<Review> reviews){

        List<ReviewRequest> reviewList = new ArrayList<>();

        for(Review rev : reviews){

            ReviewRequest rr = new ReviewRequest();
            rr.setUser(rev.getUser().getName());
            rr.setStatus(rev.getStatus());
            rr.setNews(null);
            reviewList.add(rr);
        }

        return reviewList;
    }
}
