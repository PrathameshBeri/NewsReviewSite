package springfive.cms.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springfive.cms.domain.models.Review;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserReviewsList {

    String name;
    String role;
    List<ReviewRequest> reviews;
}
