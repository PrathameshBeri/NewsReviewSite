package springfive.cms.domain.services.services;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springfive.cms.domain.models.Category;
import springfive.cms.domain.repository.CategoryRepository;
import springfive.cms.domain.utilities.Constants.DATE_TIME_LOCALES;
import springfive.cms.domain.utilities.NewsAppException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class CategoryService {


    private final CategoryRepository categoryRepository;

    private static final Logger logger = LogManager.getLogger("CategoryService.class");

    public CategoryService(CategoryRepository categoryRepository){

        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public Category update(Category category){

        return this.categoryRepository.save(category);
    }

    @Transactional
    public Category create(Category category){

        Category cat = new Category(category.getName());

        return this.categoryRepository.save(cat);

    }

    @Transactional
    public void deleteCategory(int id){

        final Optional<Category> cat = this.categoryRepository.findById(id);
        cat.ifPresent(this.categoryRepository::delete);

    }

    public List<Category> findAll(){

        return this.categoryRepository.findAll();
    }

    public Category findOne(int id){

        try {
            Category cat = this.categoryRepository.findById(id).get();
            return cat;
        }catch (NoSuchElementException e){
            logger.info("the error is " + e.toString());
            String y = LocalDate.now(ZoneId.of(DATE_TIME_LOCALES.INDIA.getRegion())).toString() + " " +
                    LocalTime.now(ZoneId.of(DATE_TIME_LOCALES.INDIA.getRegion())).toString();
            logger.info(" the time zone for the error is " + y);
            throw new NewsAppException("Error in finding ID", e.getCause().toString(), y);
        }
    }


}
