package springfive.cms.domain.resources;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfive.cms.domain.models.News;
import springfive.cms.domain.models.Review;
import springfive.cms.domain.services.services.NewsService;
import springfive.cms.vo.NewsDTO;
import springfive.cms.vo.NewsReviewsDTO;


import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsResource {


    private static final Logger logger = LogManager.getLogger(NewsResource.class);

    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<NewsDTO> findOne(@PathVariable("id") Integer id){
        NewsDTO news = newsService.getNewsById(id);
        return ResponseEntity.ok(news);
    }

    @GetMapping
    public ResponseEntity<List<NewsDTO>> getAllNews(){
        List<NewsDTO> news = newsService.getAllNews();
        return  ResponseEntity.ok(news);
    }

    @PostMapping
    public ResponseEntity<NewsDTO> createNews(@RequestBody NewsDTO news){
        logger.info("In create news method " + news.toString());
        NewsDTO savedNews =  newsService.addNews(news);
        return new ResponseEntity<>(savedNews, HttpStatus.CREATED);
    }

   // @DeleteMapping(value ="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeNews(@PathVariable("id") String id){


    }


    @GetMapping(value = "/getNewsByCategory/{category}")
    public ResponseEntity<List<NewsDTO>> getNewsByCategory(@PathVariable("category") String category){

        List<NewsDTO> newsDTOList = newsService.getNewsByCategory(category);
        return ResponseEntity.ok(newsDTOList);
    }


    @GetMapping(value = "/getReviewOnNews")
    public ResponseEntity<NewsReviewsDTO> getNewsReview(@RequestParam("id") Integer id){

        NewsReviewsDTO newsReviews = newsService.getReviews(id);
        return ResponseEntity.ok(newsReviews);
    }
/*

    @PutMapping(value = "/{id}")
    public ResponseEntity<News> updateNews(@PathVariable("id") String id, NewsRequest news){

        return new ResponseEntity(new News(), HttpStatus.OK);
    }


    @GetMapping(value = "/{id}/review/{userId}")
    public ResponseEntity<Review> review(@PathVariable("id") String id, @PathVariable("userId") String userId){
        return ResponseEntity.ok(new Review());

    }

    @GetMapping(value = "/revised")
    public ResponseEntity<List<News>> revisedNews(){

        return ResponseEntity.ok(Arrays.asList(new News(), new News()));
*/

}


