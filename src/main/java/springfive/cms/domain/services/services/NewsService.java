package springfive.cms.domain.services.services;


import springfive.cms.domain.models.News;
import springfive.cms.domain.resources.NewsResource;
import springfive.cms.vo.NewsDTO;

import java.util.List;

public interface NewsService {


    public List<NewsDTO> getAllNews();

    public NewsDTO getNewsById(Integer id);

    public NewsDTO addNews(NewsDTO news);



}
