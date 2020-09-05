package springfive.cms.domain.utilities.Mappers;

import org.modelmapper.PropertyMap;
import springfive.cms.domain.models.News;
import springfive.cms.vo.NewsDTO;



public class NewsToNewsDTO extends PropertyMap<News, NewsDTO> {
    @Override
    protected void configure() {

        map().setCategory(source.getCategory().getName());
    }
}
