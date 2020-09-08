package springfive.cms.domain.services.Implementation;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfive.cms.domain.models.Category;
import springfive.cms.domain.models.News;
import springfive.cms.domain.models.User;
import springfive.cms.domain.repository.CategoryRepository;
import springfive.cms.domain.repository.NewsRepository;
import springfive.cms.domain.repository.UserRepository;
import springfive.cms.domain.resources.NewsResource;
import springfive.cms.domain.services.services.NewsService;
import springfive.cms.domain.utilities.Mappers.NewReviewMapper;
import springfive.cms.domain.utilities.Mappers.NewsMapper;
import springfive.cms.vo.NewsDTO;
import springfive.cms.vo.NewsReviewsDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    NewsMapper newsMapper;

    @Autowired
    NewReviewMapper newsReviewMapper;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UserRepository userRepository;

    private final Logger logger = LogManager.getLogger(NewsServiceImpl.class);

    @Override
    public List<NewsDTO> getAllNews() {

        List<News> allNews = newsRepository.findAll();
        List<NewsDTO> allNewsResource= allNews.stream()
                                    .map(newsMapper::toNewsDTO)
                                    .collect(Collectors.toList());

        return allNewsResource;
    }

    @Override
    public NewsDTO getNewsById(Integer id) {
        News news= newsRepository.findById(id).get();

        return newsMapper.toNewsDTO(news);
    }

    @Override
    public NewsDTO addNews(NewsDTO news) {
        logger.info("in addNews service impl" );
        News newNews = newsMapper.toNews(news);
       logger.info("in addNews, converted news = ");
 /*       Set<User> authors  = newNews.getAuthors().stream().collect(Collectors.toSet());
        authors.stream().forEach(author -> author.getArticles().add(newNews));

        Set<User> authors = new HashSet<>();
        for(User user : newNews.getAuthors()){

           user.getArticles().add(newNews);
            authors.add(user);

        }

        newNews.setAuthors(authors);
        */

        //logger.info("authors saved" );

        //userRepository.saveAll(authors);
        News savedNews = newsRepository.save(newNews);
        logger.info("News saved");
        return newsMapper.toNewsDTO(savedNews);
    }

    @Override
    public List<NewsDTO> getNewsByCategory(String category) {

        List<News> newsByCategory = newsRepository.findNewsByCategoryName(category);
        List<NewsDTO> newsDTOList = newsMapper.toNewsDTOList(newsByCategory);
        return newsDTOList;
    }

    @Override
    public NewsReviewsDTO getReviews(Integer id) {
        News news = newsRepository.findById(id).get();
        return newsReviewMapper.toNewsReviewsDTO(news);

    }
}
