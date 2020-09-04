package springfive.cms.domain.services.Implementation;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfive.cms.domain.models.Review;
import springfive.cms.domain.models.User;
import springfive.cms.domain.repository.ReviewRepository;
import springfive.cms.domain.repository.UserRepository;
import springfive.cms.domain.services.services.ReviewService;
import springfive.cms.vo.ReviewRequest;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private static final Logger logger = LogManager.getLogger(ReviewService.class);

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Review> getAllReviews() {
       return reviewRepository.findAll();
    }

    @Override
    public Review getOneReview(int id) {

        return reviewRepository.findById(id).get();
    }

    @Override
    public Review addReview(ReviewRequest rs) {
        logger.info(rs.toString());
        Review review = new Review();
        User user = userRepository.findById(rs.getUserRequest().getId()).get();
        review.setUser(user);
        review.setStatus(rs.getStatus());
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviewByUser(Integer id) {
        List<Review> reviewsByUser= reviewRepository.findByUserId(id);

        return reviewsByUser;
    }
}
