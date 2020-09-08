package springfive.cms.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springfive.cms.domain.models.News;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserArticleList {

    String name;
    String identity;
    List<NewsDTO> articles;
}
