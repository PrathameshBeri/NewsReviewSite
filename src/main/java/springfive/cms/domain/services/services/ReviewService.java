package springfive.cms.domain.services.services;


import springfive.cms.domain.models.Review;
import springfive.cms.domain.resources.ReviewResource;
import springfive.cms.vo.ReviewRequest;

import java.util.List;

public interface ReviewService {

    public List<ReviewRequest> getAllReviews();

    public ReviewRequest getOneReview(int id);

    public ReviewRequest addReview(ReviewRequest rs);

    public List<ReviewRequest> getReviewByUser(Integer id);

}
