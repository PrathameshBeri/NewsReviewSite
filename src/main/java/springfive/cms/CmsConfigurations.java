package springfive.cms;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfive.cms.domain.utilities.Mappers.NewsDTOToNews;
import springfive.cms.domain.utilities.Mappers.NewsToNewsDTO;
import springfive.cms.domain.utilities.Mappers.ReviewToReviewResourceConverter;

@Configuration
public class CmsConfigurations {

    @Bean
    public ModelMapper modelMapper(){

        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(new ReviewToReviewResourceConverter());
        mapper.addMappings(new NewsToNewsDTO());
        mapper.addMappings(new NewsDTOToNews());
        return new ModelMapper();
    }
}
