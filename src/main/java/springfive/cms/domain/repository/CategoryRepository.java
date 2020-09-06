package springfive.cms.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import springfive.cms.domain.models.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

        //List<Category> findByName(String name);
        List<Category> findByNameIgnoreCaseStartingWith(String name);
        List<Category> findByNameContaining(String chars);
        Category findByName(String name);


}
