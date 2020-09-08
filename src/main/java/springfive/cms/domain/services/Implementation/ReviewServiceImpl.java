package springfive.cms.domain.services.Implementation;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfive.cms.domain.models.Review;
import springfive.cms.domain.models.User;
import springfive.cms.domain.repository.ReviewRepository;
import springfive.cms.domain.repository.UserRepository;
import springfive.cms.domain.resources.ReviewResource;
import springfive.cms.domain.services.services.ReviewService;
import springfive.cms.domain.utilities.Mappers.ReviewMapper;
import springfive.cms.vo.ReviewRequest;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private static final Logger logger = LogManager.getLogger(ReviewService.class);

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ReviewMapper reviewMapper;

    @Override
    public List<ReviewRequest> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviewMapper.toReviewRequestList(reviews) ;
    }

    @Override
    public ReviewRequest getOneReview(int id) {

        Review r = reviewRepository.findById(id).get();
        ReviewRequest rr = reviewMapper.toReviewRequest(r);
        logger.info("In get one review class " + rr.toString());
        return rr;
    }

    @Override
    public ReviewRequest addReview(ReviewRequest rs) {
        logger.info(rs.toString());
        Review review = reviewMapper.toReview(rs);

        logger.info("In add review " + review.toString());
        Review savedReview = reviewRepository.save(review);
        return reviewMapper.toReviewRequest(savedReview);
    }

    @Override
    public List<ReviewRequest> getReviewByUser(Integer id) {
        List<Review> reviewsByUser= reviewRepository.findByUserId(id);
        List<ReviewRequest> reviewRequestList = reviewMapper.toReviewRequestList(reviewsByUser);
        return reviewRequestList;
    }


    @Override
    public Boolean deleteReview(Integer id){

        reviewRepository.deleteById(id);

        return true;
    }
}
