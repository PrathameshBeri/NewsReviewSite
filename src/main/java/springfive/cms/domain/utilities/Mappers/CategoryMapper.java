package springfive.cms.domain.utilities.Mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import springfive.cms.domain.models.Category;
import springfive.cms.vo.CategoryRequest;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface CategoryMapper {



    CategoryRequest toCategoryRequest(Category category);

    Category toCategory(CategoryRequest categoryRequest);

    List<CategoryRequest> listCategories(List<Category> categories);


}
