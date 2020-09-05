package springfive.cms.domain.services.Implementation;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfive.cms.domain.models.Category;
import springfive.cms.domain.models.News;
import springfive.cms.domain.repository.CategoryRepository;
import springfive.cms.domain.repository.NewsRepository;
import springfive.cms.domain.resources.NewsResource;
import springfive.cms.domain.services.services.NewsService;
import springfive.cms.vo.NewsDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    CategoryRepository categoryRepository;

    private final Logger logger = LogManager.getLogger(NewsServiceImpl.class);

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<NewsDTO> getAllNews() {

        List<News> allNews = newsRepository.findAll();
        List<NewsDTO> allNewsResource= allNews.stream()
                                    .map(news -> mapper.map(news, NewsDTO.class))
                                    .collect(Collectors.toList());
        return allNewsResource;
    }

    @Override
    public NewsDTO getNewsById(Integer id) {
        News news= newsRepository.findById(id).get();

        return mapper.map(news, NewsDTO.class);
    }

    @Override
    public NewsDTO addNews(NewsDTO news) {
        logger.info("in addNews" + news.toString());
        News newNews = mapper.map(news, News.class);
        Category cat = categoryRepository.findByName(news.getCategory());
        newNews.setCategory(cat);
        logger.info("in addNews, converted news = " + newNews.toString());
        News savedNews = newsRepository.save(newNews);
        return mapper.map(savedNews, NewsDTO.class);
    }
}
