package springfive.cms.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import springfive.cms.domain.models.Review;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsDTO {


    Integer id;
    String title;
    String content;
    List<UserRequest> authors;
    String category;

    public String getCategory() {
        return category;
    }
}
