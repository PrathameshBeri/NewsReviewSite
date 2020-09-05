package springfive.cms.domain.utilities.Mappers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.PropertyMap;
import springfive.cms.domain.models.Category;
import springfive.cms.domain.models.News;
import springfive.cms.domain.repository.CategoryRepository;
import springfive.cms.vo.NewsDTO;

public class NewsDTOToNews extends PropertyMap<NewsDTO, News> {

    private static final Logger logger = LogManager.getLogger(NewsDTOToNews.class);

    @Override
    protected void configure() {


    }
}
