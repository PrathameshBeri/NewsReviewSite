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
    UserRequest userRequest;

    public UserRequest getUserReqeust() {
        return userRequest;
    }

    public void setUserRequest(UserRequest usr) {
        this.userRequest = usr;
    }
}