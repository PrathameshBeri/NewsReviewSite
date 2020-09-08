package springfive.cms.domain.services.services;


import springfive.cms.domain.models.News;
import springfive.cms.domain.resources.NewsResource;
import springfive.cms.vo.NewsDTO;
import springfive.cms.vo.NewsReviewsDTO;

import java.util.List;

public interface NewsService {


    public List<NewsDTO> getAllNews();

    public NewsDTO getNewsById(Integer id);

    public NewsDTO addNews(NewsDTO news);

    public List<NewsDTO> getNewsByCategory(String category);

    public NewsReviewsDTO getReviews(Integer id);

}
