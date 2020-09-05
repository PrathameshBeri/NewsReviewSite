package springfive.cms.domain.utilities.Mappers;

import org.modelmapper.PropertyMap;
import springfive.cms.domain.models.Review;
import springfive.cms.vo.ReviewRequest;


public class ReviewToReviewResourceConverter extends PropertyMap<Review, ReviewRequest> {


    @Override
    protected void configure() {
       // map(src -> src.getNews().getId(), Destination::setNewsId);
        map().setUserId(source.getUser().getId());
    }
}
