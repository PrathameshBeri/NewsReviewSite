package springfive.cms.domain.utilities.Mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import springfive.cms.domain.models.Review;
import springfive.cms.vo.ReviewRequest;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = ReviewMapperInternal.class)
@Component
public interface ReviewMapper {


    @Mapping(source = "user.name", target = "user")
    @Mapping(source = "news.title", target = "news")
    ReviewRequest toReviewRequest(Review review);

    Review toReview(ReviewRequest reviewRequest);

    List<ReviewRequest> toReviewRequestList(List<Review> reviews);

}
