package springfive.cms.vo;


import lombok.Data;
import springfive.cms.domain.models.Review;

import java.util.List;

@Data
public class NewsDTO {


    Integer id;
    String title;
    String content;
   // List<UserRequest> users;
    //List<ReviewRequest> reviews;
    String category;

}
