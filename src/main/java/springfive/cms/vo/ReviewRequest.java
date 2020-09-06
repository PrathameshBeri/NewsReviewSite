package springfive.cms.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {

    Integer id;
    String status;
    String user;
    String news;

}