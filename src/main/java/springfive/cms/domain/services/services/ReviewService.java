package springfive.cms.domain.services.services;


import springfive.cms.domain.models.Review;
import springfive.cms.vo.ReviewRequest;

import java.util.List;

public interface ReviewService {

    public List<Review> getAllReviews();

    public Review getOneReview(int id);

    public Review addReview(ReviewRequest rs);

    public List<Review> getReviewByUser(Integer id);

}
