package springfive.cms.domain.utilities.Mappers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import springfive.cms.domain.models.Category;
import springfive.cms.domain.repository.CategoryRepository;

public class NewDTOCategoryToCategoryConverter implements Converter<String, Category> {

    @Autowired
    private CategoryRepository categoryRepository;

    private static final Logger logger = LogManager.getLogger(NewDTOCategoryToCategoryConverter.class);
    @Override
    public Category convert(MappingContext<String, Category> mappingContext) {

        String name = mappingContext.getSource();
        logger.info(" In converter class " + name);
        Category cat = categoryRepository.findByName(name);
        logger.info(" In converter class " + cat.toString());
        return cat;
    }
}
