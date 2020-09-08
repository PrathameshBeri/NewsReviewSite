package springfive.cms.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springfive.cms.domain.models.User;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsReviewsDTO {

    Integer id;
    String title;
    String authors;
    List<ReviewRequest> reviews;


}
