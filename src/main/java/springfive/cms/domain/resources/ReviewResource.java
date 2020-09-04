package springfive.cms.domain.resources;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfive.cms.domain.models.Review;
import springfive.cms.domain.repository.ReviewRepository;
import springfive.cms.domain.services.services.ReviewService;
import springfive.cms.vo.ReviewRequest;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api/review")
public class ReviewResource {

    private static final Logger logger = LogManager.getLogger(ReviewResource.class);

    @Autowired
    ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(){
        List<Review> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
        }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Review> getOneReview(@PathVariable("id") Integer id){
        Review review = reviewService.getOneReview(id);
        return ResponseEntity.ok(review);
    }



    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody ReviewRequest reviewRequest){

        logger.info("In add review method " + reviewRequest.toString());
        Review review = reviewService.addReview(reviewRequest);
        return ResponseEntity.ok(review);
    }


    @GetMapping(value = "/reviewByUser/{id}")
    public ResponseEntity<List<Review>> getReviewsByUser(@PathVariable("id") Integer id) {
    List<Review> reviewsByUser = reviewService.getReviewByUser(id);
    return ResponseEntity.ok(reviewsByUser);
    }
}
